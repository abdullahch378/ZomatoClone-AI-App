package com.example.zomatoclone;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zomatoclone.adapters.CategoryAdapter;
import com.example.zomatoclone.adapters.RestaurantAdapter;
import com.example.zomatoclone.models.Category;
import com.example.zomatoclone.models.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    private EditText etSearch;
    private RecyclerView rvRestaurants, rvCategories;
    private LinearLayout llNoResults;

    private List<Restaurant> restaurantList;
    private List<Category> categoryList;

    private RestaurantAdapter restaurantAdapter;
    private CategoryAdapter categoryAdapter;

    public SearchFragment() { }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        etSearch = view.findViewById(R.id.etSearch);
        rvRestaurants = view.findViewById(R.id.rvRestaurantsSearch);
        rvCategories = view.findViewById(R.id.rvCategoriesSearch);
        llNoResults = view.findViewById(R.id.llNoResults);
        restaurantList = new ArrayList<>();
        categoryList = new ArrayList<>();
        restaurantList.add(new Restaurant("Pizza Place", "res1.png"));
        restaurantList.add(new Restaurant("Burger Joint", "res2.png"));
        restaurantList.add(new Restaurant("Heat Box", "res3.png"));
        restaurantList.add(new Restaurant("Pakistani Dhaba", "res4.png"));
        restaurantList.add(new Restaurant("Coffee Bar", "res5.png"));
        restaurantList.add(new Restaurant("Bismillah Hotel", "res6.png"));
        restaurantList.add(new Restaurant("Bonbird", "res7.png"));

        categoryList.add(new Category("Pizza", "cat_pizza.png"));
        categoryList.add(new Category("Burger", "cat_burger.png"));
        categoryList.add(new Category("Chinese", "cat_chinese.png"));
        categoryList.add(new Category("Briyani", "cat_briyani.png"));
        categoryList.add(new Category("Coffee", "cat_coffee.png"));
        categoryList.add(new Category("Dessert", "cat_dessert.png"));
        categoryList.add(new Category("Ice Cream", "cat_icecream.png"));
        categoryList.add(new Category("Karahi", "cat_karahi.png"));
        categoryList.add(new Category("Steak", "cat_steak.png"));

        restaurantAdapter = new RestaurantAdapter(requireContext(), restaurantList, null);
        rvRestaurants.setLayoutManager(new LinearLayoutManager(requireContext()));
        rvRestaurants.setAdapter(restaurantAdapter);

        categoryAdapter = new CategoryAdapter(requireContext(), categoryList);
        rvCategories.setLayoutManager(new GridLayoutManager(requireContext(), 3));
        rvCategories.setAdapter(categoryAdapter);

        llNoResults.setVisibility(View.GONE);
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterResults(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });

        return view;
    }

    private void filterResults(String query) {
        String q = query.toLowerCase();

        List<Restaurant> filteredRestaurants = new ArrayList<>();
        List<Category> filteredCategories = new ArrayList<>();

        for (Restaurant r : restaurantList) {
            if (r.getName().toLowerCase().contains(q)) filteredRestaurants.add(r);
        }

        for (Category c : categoryList) {
            if (c.getName().toLowerCase().contains(q)) filteredCategories.add(c);
        }

        restaurantAdapter = new RestaurantAdapter(requireContext(), filteredRestaurants, null);
        rvRestaurants.setAdapter(restaurantAdapter);

        categoryAdapter = new CategoryAdapter(requireContext(), filteredCategories);
        rvCategories.setAdapter(categoryAdapter);
        if (filteredRestaurants.isEmpty() && filteredCategories.isEmpty()) {
            llNoResults.setVisibility(View.VISIBLE);
            rvRestaurants.setVisibility(View.GONE);
            rvCategories.setVisibility(View.GONE);
        } else {
            llNoResults.setVisibility(View.GONE);
            rvRestaurants.setVisibility(View.VISIBLE);
            rvCategories.setVisibility(View.VISIBLE);
        }
    }
}
