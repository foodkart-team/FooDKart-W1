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
import com.example.foodkart.model.foodaneme;
import com.example.foodkart.orderactivity;

import java.util.List;

//RecyclerViewAdapter
public class Recycler2 extends RecyclerView.Adapter<Recycler2.MyViewHolder>{
    private Context mContext;
    private List<foodaneme> mData;
    RequestOptions option;

    public Recycler2 (Context mContext, List<foodaneme> mData) {
        this.mContext = mContext;
        this.mData = mData;
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.food_list,viewGroup,false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        viewHolder.foodlist.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, orderactivity.class);
                mContext.startActivity(i);

            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.foodname.setText(mData.get(i).getItem_name());
        myViewHolder.price.setText(mData.get(i).getPrice());

        //for image loading
        Glide.with(mContext).load(mData.get(i).getFood_image()).apply(option).into(myViewHolder.foodimage);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView foodname;
        TextView price;
        ImageView foodimage;
        LinearLayout foodlist;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            foodname = itemView.findViewById(R.id.foodname);
            price= itemView.findViewById(R.id.price);
            foodimage = itemView.findViewById(R.id.imagefood);
            foodlist=itemView.findViewById(R.id.foodlist);
        }
    }
}