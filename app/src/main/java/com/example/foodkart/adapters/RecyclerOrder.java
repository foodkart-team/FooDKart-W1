package com.example.foodkart.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.request.RequestOptions;
import com.example.foodkart.R;
import com.example.foodkart.model.order;

import java.util.List;

//RecyclerViewAdapter

public class RecyclerOrder extends RecyclerView.Adapter<RecyclerOrder.MyViewHolder> {
    private Context mContext;
    private List<order>mData;
    RequestOptions option;

    public RecyclerOrder(Context mContext, List<order> mData) {
        this.mContext = mContext;
        this.mData = mData;
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.list_of_orders,viewGroup,false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.item_name.setText(mData.get(i).getItem_name());
        myViewHolder.no_of_items.setText(mData.get(i).getNo_of_items());
        myViewHolder.order_message.setText(mData.get(i).getOrder_message());
        myViewHolder.Current_phn_num.setText(mData.get(i).getCurrent_phn_num());
        myViewHolder.Current_Location.setText(mData.get(i).getCurrent_Location());
        myViewHolder.order_time.setText(mData.get(i).getOrder_time());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView item_name;
        TextView no_of_items;
        TextView order_message;
        TextView Current_phn_num;
        TextView Current_Location;
        TextView order_time;




        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item_name = itemView.findViewById(R.id.listfitem);
            no_of_items= itemView.findViewById(R.id.listnoitem);
            order_message = itemView.findViewById(R.id.listmessage);
            Current_phn_num=itemView.findViewById(R.id.listpnumber);
            order_time=itemView.findViewById(R.id.ordertime);
            Current_Location=itemView.findViewById(R.id.listaddress);

        }
    }
}
