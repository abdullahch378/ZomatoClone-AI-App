package com.example.zomatoclone;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zomatoclone.adapter.MenuAdapter;
import com.example.zomatoclone.model.MenuItem; // Make sure MenuItem path is correct
import com.example.zomatoclone.Cart;     // Fixed import path

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    private RecyclerView rvCart;
    private MenuAdapter adapter;
    private ArrayList<MenuItem> cartItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Initialize RecyclerView
        rvCart = findViewById(R.id.rvCart);
        rvCart.setLayoutManager(new LinearLayoutManager(this));

        // Get items from cart
        cartItems = Cart.getCartItems();

        // Set Adapter
        adapter = new MenuAdapter(this, cartItems);
        rvCart.setAdapter(adapter);
    }
}
