package com.narkorazdorov.android_pract_4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<MediaHolder> {
    private List<Item> items;

    interface MyOnItemClickListener{
        void onClick(Item item, int position);
    }
    private final MyOnItemClickListener myOnItemClickListener;
    public RecyclerViewAdapter(List<Item> items, MyOnItemClickListener myOnItemClickListener) {
        this.items = items;
        this.myOnItemClickListener = myOnItemClickListener;
    }

    @NonNull
    @Override
    public MediaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        MediaHolder viewHolder = new MediaHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MediaHolder holder, int position) {
        Item item = items.get(position);
        holder.textView.setText(item.getArtistName());
        holder.imageView.setImageResource(item.getImageResourceId());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myOnItemClickListener.onClick(item,holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
