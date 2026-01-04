package com.example.zomatoclone.models;

public class Category {
    private String name, image;

    public Category(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() { return name; }
    public String getImage() { return image; }
}
