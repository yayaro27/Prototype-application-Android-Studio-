package com.example.tuto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class BoutiquePay extends Fragment {

    View view;
    RecyclerView recyclerView;
    String[] s1, s2;
    int images[] = {R.drawable.alien_masque, R.drawable.costume_clown, R.drawable.chaussonpatte_ours, R.drawable.salopette_banane, R.drawable.costume_militaire, R.drawable.masque_crocodile};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_boutique_pay, container, false);
        recyclerView = view.findViewById(R.id.recycleView);
        s1 = getResources().getStringArray(R.array.Premium);
        s2 = getResources().getStringArray(R.array.descriptionP);
        MyAdapterBoutique myAdapterBout = new MyAdapterBoutique(this.getContext(),s1,s2,images);
        recyclerView.setAdapter(myAdapterBout);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        return view;
    }
}