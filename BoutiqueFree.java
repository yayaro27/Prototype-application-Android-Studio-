package com.example.tuto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class BoutiqueFree extends Fragment {

    View view;
    RecyclerView recyclerView;
    String[] s1, s2;
    int[] images = {R.drawable.basket, R.drawable.jean, R.drawable.casquette, R.drawable.haut, R.drawable.tuba, R.drawable.jogging, R.drawable.casquette_jaune};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_boutique_free, container, false);
        recyclerView = view.findViewById(R.id.recycleView2);
        s1 = getResources().getStringArray(R.array.Normal);
        s2 = getResources().getStringArray(R.array.descriptionG);
        MyAdapterBoutique myAdapterBout = new MyAdapterBoutique(this.getContext(),s1,s2,images);
        recyclerView.setAdapter(myAdapterBout);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        return view;
    }
}