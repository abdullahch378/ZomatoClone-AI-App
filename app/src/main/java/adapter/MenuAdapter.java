package com.example.zomatoclone.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.zomatoclone.R;
import com.example.zomatoclone.models.MenuItem;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private Context context;
    private List<MenuItem> menuList;
    private OnAddToCartListener listener;

    public interface OnAddToCartListener {
        void onAddToCart(MenuItem item);
    }

    public MenuAdapter(Context context, List<MenuItem> menuList, OnAddToCartListener listener) {
        this.context = context;
        this.menuList = menuList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_menu, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        MenuItem item = menuList.get(position);

        holder.tvName.setText(item.getName());
        holder.tvPrice.setText("$" + item.getPrice());

        holder.btnAdd.setOnClickListener(v -> {
            if (listener != null) {
                listener.onAddToCart(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    static class MenuViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvPrice;
        Button btnAdd;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvMenuName);
            tvPrice = itemView.findViewById(R.id.tvMenuPrice);
            btnAdd = itemView.findViewById(R.id.btnAddToCart);
        }
    }
}
