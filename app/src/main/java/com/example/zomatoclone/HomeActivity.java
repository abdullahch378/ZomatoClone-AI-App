package com.example.zomatoclone;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zomatoclone.adapters.CategoryAdapter;
import com.example.zomatoclone.adapters.RestaurantAdapter;
import com.example.zomatoclone.models.Category;
import com.example.zomatoclone.models.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView rvRestaurants, rvCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rvRestaurants = findViewById(R.id.rvRestaurants);
        rvCategories = findViewById(R.id.rvCategories);


        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("Pizza Place", "res1.png"));
        restaurants.add(new Restaurant("Burger Joint", "res2.png"));
        restaurants.add(new Restaurant("Heat Box", "res3.png"));
        restaurants.add(new Restaurant("Pakistani Dhaba", "res4.png"));
        restaurants.add(new Restaurant("Coffee Bar", "res5.png"));
        restaurants.add(new Restaurant("Bismillah Hotel", "res6.png"));
        restaurants.add(new Restaurant("Bonbird", "res7.png"));

        RestaurantAdapter restaurantAdapter = new RestaurantAdapter(this, restaurants, restaurant -> {

            Intent intent = new Intent(HomeActivity.this, RestaurantDetailsActivity.class);
            intent.putExtra("restaurant_name", restaurant.getName());
            startActivity(intent);
        });
        rvRestaurants.setLayoutManager(new LinearLayoutManager(this));
        rvRestaurants.setAdapter(restaurantAdapter);


        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Pizza", "cat_pizza.png"));
        categories.add(new Category("Burger", "cat_burger.png"));
        categories.add(new Category("Chinese", "cat_chinese.png"));
        categories.add(new Category("Briyani", "cat_briyani.png"));
        categories.add(new Category("Coffee", "cat_coffee.png"));
        categories.add(new Category("Dessert", "cat_dessert.png"));
        categories.add(new Category("icecream", "cat_icecream.png"));
        categories.add(new Category("karahi", "cat_karahi.png"));
        categories.add(new Category("steak", "cat_steak.png"));


        CategoryAdapter categoryAdapter = new CategoryAdapter(this, categories);
        rvCategories.setLayoutManager(new GridLayoutManager(this, 3));
        rvCategories.setAdapter(categoryAdapter);
    }
}
