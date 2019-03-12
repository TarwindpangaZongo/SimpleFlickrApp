package com.example.simpleflickrapp;

import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class FlickrRecyclerVewAdapter extends RecyclerView.Adapter<FlickrRecyclerVewAdapter.ViewHolder>{
    List<Image> resultlist;

    @NonNull
    @Override
    public FlickrRecyclerVewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.image_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FlickrRecyclerVewAdapter.ViewHolder viewHolder, int i) {
        Image image= resultlist.get(i);
        viewHolder.imgName.setText(image.getName());
        Glide.with(viewHolder.itemView.getContext())
                .load(image.getUrl())
                .into(viewHolder.imageView);



    }

    @Override
    public int getItemCount() {
        return resultlist.size();
    }


    //Inner class view container.  This container holds the views that we will use for each item.
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView imgName;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgName = itemView.findViewById(R.id.name);
            imageView = itemView.findViewById(R.id.imgView);
        }
    }
}
