package com.iseeapp.isee;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.iseeapp.isee.fragments.CommentDialogFragment;
import com.iseeapp.isee.fragments.SaveImageDialogFragment;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

public class CaptureActivity extends AppCompatActivity {

    private Button buttonCancel, buttonCapture;
    private ImageView capturedImage;
    private TextView saveText;
    Bitmap imageBitmap;
    private SaveImageDialogFragment saveImageDialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //saveText = (TextView) findViewById(R.id.canweSave);
        setContentView(R.layout.activity_capture);
    }

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int SELECT_PICTURE = 100;

    public void letsCapture(View v) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    public void letsCaptureFromFile(View v) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
    }

    public void showImageSaveDialog(View v) {
        FragmentManager fm = getSupportFragmentManager();
        saveImageDialogFragment = SaveImageDialogFragment.newInstance("Some Title");
        saveImageDialogFragment.show(fm, "fragment_edit_name");
    }

    public void letsCancel(View v) {
       launchActivity(LandingActivity.class);
    }

    public void sendImageToServer(String title, String description) {
        Crouton.makeText(this, title + "was saved!", Style.CONFIRM ).show();
        capturedImage.setImageResource(R.drawable.ic_image);
        saveText.setVisibility(View.GONE);
    }

    private void launchActivity(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    /* Get the real path from the URI */
    public String getPathFromURI(Uri contentUri) {
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        capturedImage = (ImageView) findViewById(R.id.capturedImage2);
        saveText = (TextView) findViewById(R.id.canweSaveit);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            capturedImage.setImageBitmap(imageBitmap);
        } else if (requestCode == SELECT_PICTURE && resultCode == RESULT_OK) {
            Uri selectedImageUri = data.getData();
            if (null != selectedImageUri) {
                // Get the path from the Uri
                String path = getPathFromURI(selectedImageUri);
                // Set the image in ImageView
                capturedImage = (ImageView) findViewById(R.id.capturedImage2);
                capturedImage.setImageBitmap(imageBitmap);
                capturedImage.setImageURI(selectedImageUri);
            }
        }
        saveText.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
