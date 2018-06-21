package com.adityadua.cardviewdemoapp;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by AdityaDua on 21/06/18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    private ItemData[] itemDatas;

    public MyAdapter(ItemData[] itemDatas) {
        this.itemDatas = itemDatas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,null);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.titleTextView.setText(itemDatas[position].getName());
        holder.featuresTextView.setText(itemDatas[position].getFeatures());
        holder.iconImageView.setImageResource(itemDatas[position].getUrl());


        holder.titleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Clicked On : "+itemDatas[position].getName(),Snackbar.LENGTH_LONG)
                        .setAction("Action Here",null)
                        .show();

            }
        });



    }

    @Override
    public int getItemCount() {
        return itemDatas.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{


        public TextView titleTextView;
        public TextView featuresTextView;
        public ImageView iconImageView;

        public ViewHolder(View itemView) {
            super(itemView);

            titleTextView = (TextView)itemView.findViewById(R.id.textView3);
            featuresTextView = (TextView)itemView.findViewById(R.id.textView4);
            iconImageView = (ImageView)itemView.findViewById(R.id.imageView);


        }
    }
}
