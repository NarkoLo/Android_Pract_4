package com.narkorazdorov.android_pract_4;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends ArrayAdapter<Product> {
    private LayoutInflater inflater;
    private int layout;
    private List<Product> products;

    static class ViewHolder {
        TextView productTitle;
        TextView productPrice;
        ImageView productImage;
        EditText productAmount;

    }

    public ListAdapter(Context context, int resource, List<Product> products) {
        super(context, resource, products);
        this.products = products;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView =inflater.inflate(this.layout, parent, false);
            holder = new ViewHolder();
            holder.productTitle = convertView.findViewById(R.id.product_title);
            holder.productPrice = convertView.findViewById(R.id.product_price);
            holder.productImage = convertView.findViewById(R.id.product_image);
            holder.productAmount = convertView.findViewById(R.id.product_amount);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }


        Product product = products.get(position);
        holder.productTitle.setText(product.getProductTitle());
        holder.productPrice.setText(product.getProductPrice());
        holder.productAmount.setText(product.getProductAmount());
        holder.productImage.setImageResource(product.getProductImageId());
        return convertView;
    }
}
