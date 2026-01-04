package com.example.zomatoclone.models;

public class MenuItem {
    private String name;
    private double price;
    private int quantity;  // new field

    public MenuItem(String name, double price){
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }

    public String getName(){ return name; }
    public double getPrice(){ return price; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
