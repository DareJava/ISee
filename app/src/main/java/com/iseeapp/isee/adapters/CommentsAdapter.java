package com.iseeapp.isee.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

import com.iseeapp.isee.R;
import com.iseeapp.isee.pojo.Comment;

import java.util.List;

public class CommentsAdapter extends ArrayAdapter<Comment> {
    private final Context context;
    private final List<Comment> values;
    private TextView howLongAgo, message, poster;

    public CommentsAdapter(Context context, List<Comment> values) {
        super(context, R.layout.list_comments, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.list_comments, parent, false);
        howLongAgo = (TextView) rowView.findViewById(R.id.howLongAgo);
        message = (TextView) rowView.findViewById(R.id.commentMade);
        poster = (TextView) rowView.findViewById(R.id.whoPosted);

        Comment comment = values.get(position);
        poster.setText(comment.getUserAlias());
        howLongAgo.setText(comment.getPostedTime().toString());
        message.setText(comment.getMessage());

        return rowView;
    }
}