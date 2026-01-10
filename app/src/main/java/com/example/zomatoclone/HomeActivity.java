package com.example.zomatoclone;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zomatoclone.adapter.CategoryAdapter;
import com.example.zomatoclone.model.Category;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    RecyclerView rvCategories;
    CategoryAdapter categoryAdapter;
    ArrayList<Category> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        rvCategories = findViewById(R.id.rvCategories);
        rvCategories.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        );

        categories = new ArrayList<>();
        categories.add(new Category("Biryani", R.drawable.cat_briyani));
        categories.add(new Category("Burger", R.drawable.cat_burger));
        categories.add(new Category("Chinese", R.drawable.cat_chinese));
        categories.add(new Category("Pizza", R.drawable.cat_pizza));
        categories.add(new Category("Coffee", R.drawable.cat_coffee));
        categories.add(new Category("Dessert", R.drawable.cat_dessert));
        categories.add(new Category("Ice cream", R.drawable.cat_icecream));
        categories.add(new Category("Steak", R.drawable.cat_steak));
        categories.add(new Category("Karahi", R.drawable.cat_karahi));

        categoryAdapter = new CategoryAdapter(this, categories);
        rvCategories.setAdapter(categoryAdapter);

        // Sample restaurant data
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("Biryani House", R.drawable.res1));
        restaurants.add(new Restaurant("Burger King", R.drawable.res2));
        restaurants.add(new Restaurant("Chinese Wok", R.drawable.res3));
        restaurants.add(new Restaurant("Coffee Corner", R.drawable.res4));
        restaurants.add(new Restaurant("Dessert Hub", R.drawable.res5));
        restaurants.add(new Restaurant("Pizza Planet", R.drawable.res6));
        restaurants.add(new Restaurant("Steak House", R.drawable.res7));

        RecyclerView rvRestaurants = view.findViewById(R.id.rvRestaurants);
        rvRestaurants.setAdapter(new RestaurantAdapter(getContext(), restaurants));
        rvRestaurants.setLayoutManager(new LinearLayoutManager(getContext()));

    }
}
