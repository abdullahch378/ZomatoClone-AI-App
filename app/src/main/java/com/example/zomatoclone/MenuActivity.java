package com.example.zomatoclone;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zomatoclone.adapters.MenuAdapter;
import com.example.zomatoclone.models.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    private RecyclerView rvMenu;
    private LinearLayout rootLayout;
    private List<MenuItem> menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        rvMenu = findViewById(R.id.rvMenu);
        rootLayout = findViewById(R.id.rootLayout);

        menuList = new ArrayList<>();
        menuList.add(new MenuItem("Pizza", 12.5));
        menuList.add(new MenuItem("Burger", 8.0));
        menuList.add(new MenuItem("Pasta", 10.0));
        menuList.add(new MenuItem("Salad", 7.0));
        menuList.add(new MenuItem("Fries", 5.0));

        MenuAdapter adapter = new MenuAdapter(this, menuList, item -> {
            if (!CartActivity.cartList.contains(item)) {
                CartActivity.cartList.add(item);
                Toast.makeText(MenuActivity.this, item.getName() + " added to cart", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MenuActivity.this, item.getName() + " already in cart", Toast.LENGTH_SHORT).show();
            }
        });

        rvMenu.setLayoutManager(new LinearLayoutManager(this));
        rvMenu.setAdapter(adapter);
        TextView btnViewCart = new TextView(this);
        btnViewCart.setText("View Cart (" + CartActivity.cartList.size() + ")");
        btnViewCart.setPadding(20, 20, 20, 20);
        btnViewCart.setBackgroundColor(getResources().getColor(R.color.primaryColor));
        btnViewCart.setTextColor(getResources().getColor(R.color.white));
        btnViewCart.setTextSize(18f);
        btnViewCart.setOnClickListener(v -> {
            startActivity(new Intent(MenuActivity.this, CartActivity.class));
        });

        rootLayout.addView(btnViewCart);
    }
}
