package com.example.zomatoclone;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zomatoclone.adapter.MenuAdapter;
import com.example.zomatoclone.model.MenuItem;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    RecyclerView rvMenu;
    MenuAdapter menuAdapter;
    ArrayList<MenuItem> menuItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        rvMenu = findViewById(R.id.rvMenu);

        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Briyani", 300, R.drawable.cat_briyani));
        menuItems.add(new MenuItem("Burger", 250, R.drawable.cat_burger));
        menuItems.add(new MenuItem("Chinese Noodles", 200, R.drawable.cat_chinese));
        menuItems.add(new MenuItem("Coffee", 150, R.drawable.cat_coffee));
        menuItems.add(new MenuItem("Dessert", 180, R.drawable.cat_dessert));
        menuItems.add(new MenuItem("Ice Cream", 120, R.drawable.cat_icecream));
        menuItems.add(new MenuItem("Karahi", 350, R.drawable.cat_karahi));
        menuItems.add(new MenuItem("Pizza", 400, R.drawable.cat_pizza));
        menuItems.add(new MenuItem("Steak", 500, R.drawable.cat_steak));

        menuAdapter = new MenuAdapter(menuItems, this);
        rvMenu.setAdapter(menuAdapter);
        rvMenu.setLayoutManager(new LinearLayoutManager(this));
    }
}
