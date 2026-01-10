package com.example.zomatoclone;

import com.example.zomatoclone.model.MenuItem;

import java.util.ArrayList;

public class Cart {
    private static ArrayList<MenuItem> cartItems = new ArrayList<>();

    public static void addItem(MenuItem item) {
        cartItems.add(item);
    }

    public static ArrayList<MenuItem> getCartItems() {
        return cartItems;
    }

    public static void clearCart() {
        cartItems.clear();
    }
}
