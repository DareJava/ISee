package com.iseeapp.isee.fragments;

import android.app.AlertDialog;
import android.app.Dialog;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;

import com.iseeapp.isee.BreakdownActivity;
import com.iseeapp.isee.R;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

/**
 * Created by dare.fatimehin on 07/05/2017.
 */

public class CommentDialogFragment extends DialogFragment {

    private EditText mEditText;
    private ImageButton close;
    private ImageButton addComment;

    public CommentDialogFragment() {
        // Empty constructor is required for DialogFragment
        // Make sure not to add arguments to the constructor
        // Use `newInstance` instead as shown below
    }

    public static CommentDialogFragment newInstance(String title) {
        CommentDialogFragment frag = new CommentDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }

    private void closeCommentDialog(View v) {
        this.dismiss();
    }

    private void addComment(View v) {
        String comment = ((EditText)v).getText().toString();
        this.dismiss();
        Crouton.makeText(getActivity().getParent(), "was typed in!", Style.CONFIRM ).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_comment, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Get field from view
        mEditText = (EditText) view.findViewById(R.id.txt_your_name);
        close = (ImageButton) view.findViewById(R.id.close);
        addComment = (ImageButton) view.findViewById(R.id.addComment);

        close.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        addComment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ((BreakdownActivity)getActivity()).addComment(mEditText.getText().toString());
            }
        });
        mEditText.requestFocus();
        Window window = getDialog().getWindow();
        window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color
                .TRANSPARENT));
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.dimAmount = 1.0f;
        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

}