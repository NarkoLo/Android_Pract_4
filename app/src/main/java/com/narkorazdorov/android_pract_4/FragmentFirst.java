package com.narkorazdorov.android_pract_4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentFirst extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        Button button1 = view.findViewById(R.id.button1);
        button1.setOnClickListener(view1 -> {
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            FragmentSecond secondFragment = new FragmentSecond();
            fragmentTransaction.replace(R.id.fragment_container, secondFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });

        Button button2 = view.findViewById(R.id.button2);
        button2.setOnClickListener(view12 -> {
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            FragmentThird thirdFragment = new FragmentThird();
            fragmentTransaction.replace(R.id.fragment_container, thirdFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        });
        return view;
    }
}
