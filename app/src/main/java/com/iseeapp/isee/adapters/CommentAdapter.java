package com.iseeapp.isee.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iseeapp.isee.R;
import com.iseeapp.isee.pojo.Comment;


import java.util.List;


import com.iseeapp.isee.pojo.Comment;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.MyViewHolder> {

    private List<Comment> commentList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView howLongAgo, message, poster;

        public MyViewHolder(View view) {
            super(view);
            howLongAgo = (TextView) view.findViewById(R.id.howLongAgo);
            message = (TextView) view.findViewById(R.id.commentMade);
            poster = (TextView) view.findViewById(R.id.poster);

        }
    }


    public CommentAdapter(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_trending, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Comment item = commentList.get(position);
        holder.poster.setText(item.getUserAlias());
        holder.howLongAgo.setText(item.getPostedTime().toString());
        holder.message.setText(item.getMessage());
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }
}