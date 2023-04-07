package com.narkorazdorov.android_pract_4;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends ArrayAdapter<Item> {
    private LayoutInflater inflater;
    private int layout;
    private List<Item> items;

    static class ViewHolder {
        TextView textView;
        ImageView imageView;
    }

    public ListAdapter(Context context, int resource, List<Item> items) {
        super(context, resource, items);
        this.items = items;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView =inflater.inflate(this.layout, parent, false);
            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.textView);
            holder.imageView = convertView.findViewById(R.id.imageView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }


        Item item = items.get(position);
        holder.textView.setText(item.getArtistName());
        holder.imageView.setImageResource(item.getImageResourceId());
        return convertView;
    }
}
