package com.example.zomatoclone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zomatoclone.adapter.CategoryAdapter;
import com.example.zomatoclone.adapter.RestaurantAdapter;
import com.example.zomatoclone.model.Category;
import com.example.zomatoclone.model.Restaurant;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    RecyclerView rvCategories, rvRestaurants;
    CategoryAdapter categoryAdapter;
    RestaurantAdapter restaurantAdapter;

    ArrayList<Category> categories;
    ArrayList<Restaurant> restaurants;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        rvCategories = view.findViewById(R.id.rvCategories);
        rvRestaurants = view.findViewById(R.id.rvRestaurants);

        // Categories
        categories = new ArrayList<>();
        categories.add(new Category("Briyani", R.drawable.cat_briyani));
        categories.add(new Category("Burger", R.drawable.cat_burger));
        categories.add(new Category("Chinese", R.drawable.cat_chinese));
        categories.add(new Category("Coffee", R.drawable.cat_coffee));
        categories.add(new Category("Dessert", R.drawable.cat_dessert));
        categories.add(new Category("Ice Cream", R.drawable.cat_icecream));
        categories.add(new Category("Karahi", R.drawable.cat_karahi));
        categories.add(new Category("Pizza", R.drawable.cat_pizza));
        categories.add(new Category("Steak", R.drawable.cat_steak));

        categoryAdapter = new CategoryAdapter(getContext(), categories);
        rvCategories.setAdapter(categoryAdapter);
        rvCategories.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        // Restaurants
        restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("Biryani House", R.drawable.res1));
        restaurants.add(new Restaurant("Burger King", R.drawable.res2));
        restaurants.add(new Restaurant("Chinese Wok", R.drawable.res3));
        restaurants.add(new Restaurant("Coffee Corner", R.drawable.res4));
        restaurants.add(new Restaurant("Dessert Hub", R.drawable.res5));
        restaurants.add(new Restaurant("Pizza Planet", R.drawable.res6));
        restaurants.add(new Restaurant("Steak House", R.drawable.res7));

        restaurantAdapter = new RestaurantAdapter(getContext(), restaurants);
        rvRestaurants.setAdapter(restaurantAdapter);
        rvRestaurants.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}
