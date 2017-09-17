package com.iseeapp.isee.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iseeapp.isee.R;
import com.iseeapp.isee.pojo.UploadedResource;

import java.util.List;


public class FilteredUploadResourceAdapter extends RecyclerView.Adapter<FilteredUploadResourceAdapter.MyViewHolder> {

    private List<UploadedResource> uploadList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView imageTitle, description, likeCount, commentCount, poster;

        public MyViewHolder(View view) {
            super(view);
            imageTitle = (TextView) view.findViewById(R.id.imageTitle);
            description = (TextView) view.findViewById(R.id.description);
            likeCount = (TextView) view.findViewById(R.id.likeCount);
            commentCount = (TextView) view.findViewById(R.id.commentCount);
            poster = (TextView) view.findViewById(R.id.poster);

        }
    }


    public FilteredUploadResourceAdapter(List<UploadedResource> moviesList) {
        this.uploadList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_trending, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        UploadedResource item = uploadList.get(position);
        holder.imageTitle.setText(item.getTitle());
        holder.description.setText(item.getDescription());
        holder.likeCount.setText("25 likes");
        holder.commentCount.setText("45 comments");
    }

    @Override
    public int getItemCount() {
        return uploadList.size();
    }
}