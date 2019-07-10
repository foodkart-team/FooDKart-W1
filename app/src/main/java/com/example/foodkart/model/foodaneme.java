package com.example.foodkart.model;

public class foodaneme {

    private String item_name;
    private String food_image;
    private String price;

    public foodaneme() {
    }

    public foodaneme(String item_name, String food_image, String price) {
        this.item_name = item_name;
        this.food_image = food_image;
        this.price = price;
    }

    public String getItem_name() {
        return item_name;
    }

    public String getFood_image() {
        return food_image;
    }

    public String getPrice() {
        return price;
    }

    public void setFood_image(String food_image) {
        this.food_image = food_image;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }
}
