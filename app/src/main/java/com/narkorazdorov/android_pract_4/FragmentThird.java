package com.narkorazdorov.android_pract_4;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FragmentThird extends Fragment {
    List<Product> products = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerViewAdapter.OnProductClickListener listener = new RecyclerViewAdapter.OnProductClickListener() {
            @Override
            public void onClick(Product product, int position) {

            }
        };
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        for (int i = 0; i < 200; i++) {
            products.add(new Product("Beer", new Random().nextDouble()*10 + " $",R.drawable.beer));
        }

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(products, listener);
        recyclerView.setAdapter(adapter);

    }
}
