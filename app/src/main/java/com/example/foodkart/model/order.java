package com.example.foodkart.model;

public class order {
    String item_name;
    String no_of_items;
    String order_message;
    long  Current_phn_num;
    String Current_Location;
    String Order_time;
    String Order_number;
    public order() {
    }
    public order(String item_name, String no_of_items, String order_message, long current_phn_num, String current_Location,String order_time) {
        this.item_name = item_name;
        this.no_of_items = no_of_items;
        this.order_message = order_message;
        this.Current_phn_num = current_phn_num;
        this.Current_Location = current_Location;
        this.Order_time = Order_time;
        this.Order_number=Order_number;
    }

    public String getOrder_number() {
        return Order_number;
    }

    public void setOrder_number(String order_number) {
        Order_number = order_number;
    }
    public String getItem_name() {
        return item_name;
    }

    public String getOrder_time() {
        return Order_time;
    }

    public void setOrder_time(String order_time) {
        Order_time = order_time;
    }

    public String getNo_of_items() {
        return no_of_items;
    }

    public String getOrder_message() {
        return order_message;
    }

    public long getCurrent_phn_num() {
        return Current_phn_num;
    }

    public String getCurrent_Location() {
        return Current_Location;
    }


    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public void setNo_of_items(String no_of_items) {
        this.no_of_items = no_of_items;
    }

    public void setOrder_message(String order_message) {
        this.order_message = order_message;
    }

    public void setCurrent_phn_num(long current_phn_num) {
        this.Current_phn_num = current_phn_num;
    }

    public void setCurrent_Location(String current_Location) {
        this.Current_Location = current_Location;
    }
}


