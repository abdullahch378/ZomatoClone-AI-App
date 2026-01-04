package com.example.zomatoclone;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zomatoclone.adapters.MenuAdapter;
import com.example.zomatoclone.models.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class RestaurantDetailsActivity extends AppCompatActivity {

    private RecyclerView rvMenu;
    private LinearLayout rootLayout;
    private List<MenuItem> menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);

        rvMenu = findViewById(R.id.rvMenu);
        rootLayout = findViewById(R.id.rootLayout);
        menu = new ArrayList<>();
        menu.add(new MenuItem("Pizza", 12.5));
        menu.add(new MenuItem("Burger", 8.0));
        menu.add(new MenuItem("Pasta", 10.0));
        menu.add(new MenuItem("Salad", 7.0));
        menu.add(new MenuItem("Fries", 5.0));

        MenuAdapter adapter = new MenuAdapter(this, menu, item -> {
            if (!CartActivity.cartList.contains(item)) {
                CartActivity.cartList.add(item);
                Toast.makeText(RestaurantDetailsActivity.this,
                        item.getName() + " added to cart", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(RestaurantDetailsActivity.this,
                        item.getName() + " already in cart", Toast.LENGTH_SHORT).show();
            }
        });

        rvMenu.setLayoutManager(new LinearLayoutManager(this));
        rvMenu.setAdapter(adapter);
        Button btnViewCart = new Button(this);
        btnViewCart.setText("View Cart (" + CartActivity.cartList.size() + ")");
        btnViewCart.setBackgroundColor(getResources().getColor(R.color.primaryColor));
        btnViewCart.setTextColor(getResources().getColor(R.color.white));
        btnViewCart.setOnClickListener(v -> {
            startActivity(new android.content.Intent(RestaurantDetailsActivity.this, CartActivity.class));
        });

        rootLayout.addView(btnViewCart);
    }
}
