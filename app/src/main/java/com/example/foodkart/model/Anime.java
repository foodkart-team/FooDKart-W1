package com.example.foodkart.model;

public class Anime {

    private String r_name;
    private String r_address;
    private String image;
    public Anime() {
    }

    public Anime(String r_name,String r_address , String image) {
        this.r_name = r_name;
        this.image = image;
        this.r_address = r_address;
    }

    public String getR_name() {
        return r_name;
    }

    public String getImage() {
        return image;
    }
    public String getR_address(){
        return r_address;
    }

    public void setR_address(String r_address){
        this.r_address = r_address;
    }
    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
