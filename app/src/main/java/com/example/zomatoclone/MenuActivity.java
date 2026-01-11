package com.example.zomatoclone;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zomatoclone.adapter.MenuAdapter;
import com.example.zomatoclone.model.MenuItem;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity
{

    RecyclerView rvMenu;
    MenuAdapter menuAdapter;
    ArrayList<MenuItem> menuItems;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        rvMenu = findViewById(R.id.rvMenu);
        rvMenu.setLayoutManager(new LinearLayoutManager(this));

        menuItems = new ArrayList<>();

        // ✅ MENU ITEMS USING YOUR DRAWABLES
        menuItems.add(new MenuItem("Biryani", 300.0, R.drawable.cat_briyani));
        menuItems.add(new MenuItem("Burger", 450.0, R.drawable.cat_burger));
        menuItems.add(new MenuItem("Chinese", 600.0, R.drawable.cat_chinese));
        menuItems.add(new MenuItem("Coffee", 250.0, R.drawable.cat_coffee));
        menuItems.add(new MenuItem("Dessert", 500.0, R.drawable.cat_dessert));
        menuItems.add(new MenuItem("Ice Cream", 350.0, R.drawable.cat_icecream));
        menuItems.add(new MenuItem("Karahi", 1200.0, R.drawable.cat_karahi));
        menuItems.add(new MenuItem("Pizza", 1000.0, R.drawable.cat_pizza));
        menuItems.add(new MenuItem("Steak", 1500.0, R.drawable.cat_steak));

        // ✅ CORRECT ADAPTER CALL (Context FIRST)
        menuAdapter = new MenuAdapter(this, menuItems);
        rvMenu.setAdapter(menuAdapter);
    }
}
