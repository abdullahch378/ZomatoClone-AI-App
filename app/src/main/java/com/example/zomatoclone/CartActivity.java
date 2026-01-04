package com.example.zomatoclone;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.zomatoclone.models.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    public static List<MenuItem> cartList = new ArrayList<>();

    private LinearLayout llCartItems;
    private Button btnConfirmOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        llCartItems = findViewById(R.id.llCartItems);
        btnConfirmOrder = findViewById(R.id.btnConfirmOrder);

        displayCartItems();

        btnConfirmOrder.setOnClickListener(v -> {

            cartList.clear();

            startActivity(new Intent(CartActivity.this, OrderSuccessActivity.class));
            finish();
        });
    }

    private void displayCartItems() {
        llCartItems.removeAllViews();

        if(cartList.isEmpty()){
            TextView tvEmpty = new TextView(this);
            tvEmpty.setText("Your cart is empty!");
            tvEmpty.setTextSize(16f);
            llCartItems.addView(tvEmpty);
        } else {
            for(MenuItem item : cartList){
                TextView tvItem = new TextView(this);
                tvItem.setText(item.getName() + " - $" + item.getPrice());
                tvItem.setTextSize(16f);
                llCartItems.addView(tvItem);
            }
        }
    }
}
