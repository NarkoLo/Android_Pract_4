package com.narkorazdorov.android_pract_4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<MediaHolder> {
    private List<Product> products;

    interface OnProductClickListener{
        void onClick(Product product, int position);
    }
    private final OnProductClickListener onProductClickListener;
    public RecyclerViewAdapter(List<Product> products, OnProductClickListener productClickListener) {
        this.products = products;
        this.onProductClickListener = productClickListener;
    }

    @NonNull
    @Override
    public MediaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        return new MediaHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MediaHolder holder, int position) {
        Product product = products.get(position);
        holder.productTitle.setText(product.getProductTitle());
        holder.productAmount.setText(product.getProductAmount());
        holder.productPrice.setText(product.getProductPrice());
        holder.productImage.setImageResource(product.getProductImageId());
        holder.itemView.setOnClickListener(v -> onProductClickListener.onClick(product,holder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
