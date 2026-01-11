package com.example.zomatoclone;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zomatoclone.adapter.CategoryAdapter;
import com.example.zomatoclone.adapter.RestaurantAdapter;
import com.example.zomatoclone.model.Category;
import com.example.zomatoclone.model.Restaurant;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    RecyclerView rvCategories, rvRestaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rvCategories = findViewById(R.id.rvCategories);
        rvRestaurants = findViewById(R.id.rvRestaurants);

        // ---------------- Categories ----------------
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category("Briyani", R.drawable.cat_briyani));
        categories.add(new Category("Burger", R.drawable.cat_burger));
        categories.add(new Category("Chinese", R.drawable.cat_chinese));
        categories.add(new Category("Coffee", R.drawable.cat_coffee));
        categories.add(new Category("Dessert", R.drawable.cat_dessert));
        categories.add(new Category("Ice Cream", R.drawable.cat_icecream));
        categories.add(new Category("Karahi", R.drawable.cat_karahi));
        categories.add(new Category("Pizza", R.drawable.cat_pizza));
        categories.add(new Category("Steak", R.drawable.cat_steak));

        CategoryAdapter categoryAdapter =
                new CategoryAdapter(this, categories);

        rvCategories.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        );
        rvCategories.setAdapter(categoryAdapter);

        // ---------------- Restaurants ----------------
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("Food Hub", R.drawable.res1));
        restaurants.add(new Restaurant("Spicy Bite", R.drawable.res2));
        restaurants.add(new Restaurant("Burger Town", R.drawable.res3));
        restaurants.add(new Restaurant("Chinese Wok", R.drawable.res4));
        restaurants.add(new Restaurant("Coffee Corner", R.drawable.res5));
        restaurants.add(new Restaurant("Dessert House", R.drawable.res6));
        restaurants.add(new Restaurant("Steak House", R.drawable.res7));

        RestaurantAdapter restaurantAdapter =
                new RestaurantAdapter(this, restaurants);

        rvRestaurants.setLayoutManager(
                new LinearLayoutManager(this)
        );
        rvRestaurants.setAdapter(restaurantAdapter);
    }
}
