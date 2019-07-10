package com.example.foodkart.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.foodkart.R;
import com.example.foodkart.fooditems;
import com.example.foodkart.model.Anime;

import java.util.List;

//RecyclerViewAdapter

public class Recycler extends RecyclerView.Adapter<Recycler.MyViewHolder> {
private Context mContext;
private List<Anime>mData;
RequestOptions option;

    public Recycler(Context mContext, List<Anime> mData) {
        this.mContext = mContext;
        this.mData = mData;
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.row_items,viewGroup,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.reslist.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, fooditems.class);
                mContext.startActivity(i);

            }
        });
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.name.setText(mData.get(i).getR_name());
        myViewHolder.about.setText(mData.get(i).getR_address());

        //for image loading
        Glide.with(mContext).load(mData.get(i).getImage()).apply(option).into(myViewHolder.img_thumbnail);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
       TextView name;
       TextView about;
       ImageView img_thumbnail;
       LinearLayout reslist;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.res_name);
            about = itemView.findViewById(R.id.about2);
            img_thumbnail = itemView.findViewById(R.id.respic);
            reslist=itemView.findViewById(R.id.reslist);
        }
    }
}
