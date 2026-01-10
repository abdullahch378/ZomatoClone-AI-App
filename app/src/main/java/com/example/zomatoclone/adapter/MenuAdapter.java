package com.example.zomatoclone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zomatoclone.Cart;
import com.example.zomatoclone.R;
import com.example.zomatoclone.model.MenuItem;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    ArrayList<MenuItem> menuItems;
    Context context;

    public MenuAdapter(ArrayList<MenuItem> menuItems, Context context) {
        this.menuItems = menuItems;
        this.context = context;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_menu, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        MenuItem item = menuItems.get(position);
        holder.tvMenuName.setText(item.getName());
        holder.tvMenuPrice.setText("₹" + item.getPrice());
        holder.btnAddToCart.setOnClickListener(v -> {
            Cart.addItem(item);
            Toast.makeText(context, item.getName() + " added to cart",

                    Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    static class MenuViewHolder extends RecyclerView.ViewHolder {
        TextView tvMenuName, tvMenuPrice;
        Button btnAddToCart;
        ImageView imgMenu;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMenuName = itemView.findViewById(R.id.tvMenuName);
            tvMenuPrice = itemView.findViewById(R.id.tvMenuPrice);
            btnAddToCart = itemView.findViewById(R.id.btnAddToCart);
        }
    }
}
