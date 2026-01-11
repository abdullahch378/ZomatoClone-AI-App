package com.example.zomatoclone.model;

public class Restaurant {

    private String name;
    private int image; // this should match the drawable resource ID

    public Restaurant(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
}
