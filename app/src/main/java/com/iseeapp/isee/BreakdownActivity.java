package com.iseeapp.isee;

import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatDialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.iseeapp.isee.adapters.CommentsAdapter;
import com.iseeapp.isee.fragments.CommentDialogFragment;
import com.iseeapp.isee.pojo.Comment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

public class BreakdownActivity extends AppCompatActivity {


    private LinearLayout stickyView;
    private FloatingActionButton fabAction;
    private ListView listView;
    private List listOfComments;
    private View heroImageView;
    private View stickyViewSpacer;
    private int MAX_ROWS = 21;
    private CommentDialogFragment commentDialogFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakdown);
        listOfComments = new ArrayList();
        /* Initialise list view, hero image, and sticky view */
        listView = (ListView) findViewById(R.id.listView);
        heroImageView = findViewById(R.id.heroImageView);
        stickyView = (LinearLayout) findViewById(R.id.stickyView);
        fabAction = (FloatingActionButton) findViewById(R.id.fab);
        /* Inflate list header layout */
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listHeader = inflater.inflate(R.layout.list_layout_work, null);
        stickyViewSpacer = listHeader.findViewById(R.id.stickyViewPlaceholder);
        /* Add list view header */
        listView.addHeaderView(listHeader);
        /* Handle list View scroll events */
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                /* Check if the first item is already reached to top.*/
                if (listView.getFirstVisiblePosition() == 0) {
                    View firstChild = listView.getChildAt(0);
                    int topY = 0;
                    if (firstChild != null) {
                        topY = firstChild.getTop();
                    }
                    int heroTopY = stickyViewSpacer.getTop();
                    stickyView.setY(Math.max(0, heroTopY + topY));
                    /* Set the image to scroll half of the amount that of ListView */
                    heroImageView.setY(topY * 0.5f);
                }
            }
        });
        prepareData();
        CommentsAdapter cmAdapter = new CommentsAdapter(this, listOfComments);
        listView.setAdapter(cmAdapter);

        addFloatingActionButton(fabAction);
        doLongClick(listView);
        //setOnTouchListener(listView);

    }

    private void setOnTouchListener(ListView lv) {
        final GestureDetector gestureDetector = new GestureDetector(new CustomGestureListener(this));
        View.OnTouchListener gestureListener = new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }};
        lv.setOnTouchListener(gestureListener);
    }


    private void addFloatingActionButton(FloatingActionButton fabAction) {

        fabAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click action
                showCommentDialog();
//                Toast.makeText(getApplicationContext(),"Want to add a new comment! Yipee!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void closeCommentDialog(View v) {
        commentDialogFragment.dismiss();
    }

    public void addComment(String message) {
        commentDialogFragment.dismiss();
        Crouton.makeText(this, message + "was typed in!", Style.CONFIRM ).show();
    }

    private void refreshComments (String message) {

        // in Ideal situations load from backend fresh data

    }

    private void showCommentDialog() {
        FragmentManager fm = getSupportFragmentManager();
        commentDialogFragment = CommentDialogFragment.newInstance("Some Title");
        commentDialogFragment.show(fm, "fragment_edit_name");
    }

    private void doLongClick(ListView view) {
        view.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                deleteMyPost();
                return true;
            }
        });
    }

    private void deleteMyPost() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set title
        alertDialogBuilder.setTitle("Your Title");

        // set dialog message
        alertDialogBuilder
                .setMessage("Are you sure you want to delete this post?")
                .setCancelable(false)
                .setPositiveButton("Sure",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, close
                        // current activity

                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();


    }
    private void prepareData(){

        Comment c = new Comment();
        c.setMessage("If men were God, we would have seen the worst of all occasions on this neural network but in case like this we are quite pleased that God is not man and he g");
        c.setUserAlias("Ibrahim Kabir");
        c.setPostedTime("10 seconds ago");
        Comment c2 = new Comment();
        c2.setMessage("What a distastefulpicture, i hope very many people are reporting such pictures");
        c2.setUserAlias("Steven007");
        c2.setPostedTime("1hr ago");
        Comment c3 = new Comment();
        c3.setMessage("Whatever this message carries we have to be sincere with our leaders and burn them to ashes just like the indians. Too criminal men of the government. Thanks");
        c3.setUserAlias("Seyi David");
        c3.setPostedTime("2hrs ago");
        Comment c4 = new Comment();
        c4.setMessage("Fantastic job you guys are doings, its a pleasure to get this off our neck. i am proud of the work you have shown");
        c4.setUserAlias("Slayer1997");
        c4.setPostedTime("2 days ago");
        listOfComments.add(c);
        listOfComments.add(c2);
        listOfComments.add(c3);
        listOfComments.add(c4);
        listOfComments.add(c4);
        listOfComments.add(c4);
        listOfComments.add(c4);
        listOfComments.add(c4);
    }
}
