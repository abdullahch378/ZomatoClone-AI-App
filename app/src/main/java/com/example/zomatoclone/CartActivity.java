package com.example.zomatoclone;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zomatoclone.adapter.MenuAdapter;

public class CartActivity extends AppCompatActivity {

    RecyclerView rvCart;
    Button btnCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        rvCart = findViewById(R.id.rvCart);
        btnCheckout = findViewById(R.id.btnCheckout);

        rvCart.setAdapter(new MenuAdapter(Cart.getCartItems(), this));
        rvCart.setLayoutManager(new LinearLayoutManager(this));

        btnCheckout.setOnClickListener(v -> {
            startActivity(new Intent(CartActivity.this, OrderSuccessActivity.class));
            Cart.clearCart();
            finish();
        });
    }
}
