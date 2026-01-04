package com.example.zomatoclone.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zomatoclone.R;
import com.example.zomatoclone.models.Restaurant;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {

    private Context context;
    private List<Restaurant> restaurantList;
    private OnRestaurantClickListener listener;

    public interface OnRestaurantClickListener {
        void onRestaurantClick(Restaurant restaurant);
    }

    public RestaurantAdapter(Context context, List<Restaurant> restaurantList, OnRestaurantClickListener listener) {
        this.context = context;
        this.restaurantList = restaurantList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_restaurant, parent, false);
        return new RestaurantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {
        Restaurant restaurant = restaurantList.get(position);
        holder.tvName.setText(restaurant.getName());
        int resId = context.getResources().getIdentifier(
                restaurant.getImage().replace(".png", ""),
                "drawable",
                context.getPackageName()
        );
        holder.imgRestaurant.setImageResource(resId);

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onRestaurantClick(restaurant);
            }
        });
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    static class RestaurantViewHolder extends RecyclerView.ViewHolder {
        ImageView imgRestaurant;
        TextView tvName;

        public RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);
            imgRestaurant = itemView.findViewById(R.id.imgRestaurant);
            tvName = itemView.findViewById(R.id.tvRestaurantName);
        }
    }
}
