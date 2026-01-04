package com.example.zomatoclone.models;

public class Restaurant {
    private String name, image;

    public Restaurant(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() { return name; }
    public String getImage() { return image; }
}
