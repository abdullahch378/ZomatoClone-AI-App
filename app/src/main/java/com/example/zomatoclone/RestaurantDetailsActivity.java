package com.example.zomatoclone;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zomatoclone.adapter.MenuAdapter;
import com.example.zomatoclone.model.MenuItem;

import java.util.ArrayList;

public class RestaurantDetailsActivity extends AppCompatActivity {

    private RecyclerView rvMenu;
    private MenuAdapter menuAdapter;
    private ArrayList<MenuItem> menuItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);

        rvMenu = findViewById(R.id.rvMenu);

        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Briyani", 300.0, R.drawable.cat_briyani));
        menuItems.add(new MenuItem("Burger", 250.0, R.drawable.cat_burger));
        menuItems.add(new MenuItem("Pizza", 600.0, R.drawable.cat_pizza));
        menuItems.add(new MenuItem("Karahi", 1200.0, R.drawable.cat_karahi));
        menuItems.add(new MenuItem("Chinese", 300.0, R.drawable.cat_chinese));
        menuItems.add(new MenuItem("Coffee", 250.0, R.drawable.cat_coffee));
        menuItems.add(new MenuItem("Dessert", 600.0, R.drawable.cat_dessert));
        menuItems.add(new MenuItem("Icecream", 1200.0, R.drawable.cat_icecream));

        menuAdapter = new MenuAdapter(this, menuItems);
        rvMenu.setAdapter(menuAdapter);
    }
}
