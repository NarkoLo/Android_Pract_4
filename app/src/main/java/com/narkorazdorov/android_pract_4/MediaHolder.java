package com.narkorazdorov.android_pract_4;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MediaHolder extends RecyclerView.ViewHolder{
    TextView productTitle;
    TextView productPrice;
    ImageView productImage;
    EditText productAmount;

    public MediaHolder(@NonNull View productView) {
        super(productView);
        productTitle = productView.findViewById(R.id.product_title);
        productPrice = productView.findViewById(R.id.product_price);
        productImage = productView.findViewById(R.id.product_image);
        productAmount = productView.findViewById(R.id.product_amount);
    }
}
