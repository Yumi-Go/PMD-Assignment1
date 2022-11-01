package com.example.assignment1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class Food_Tab1Fragment extends Fragment {

    RecyclerView recyclerView;
    List<RecyclerItem> itemsList = new ArrayList<>();



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initItems();
//        // This callback will only be called when MyFragment is at least Started.
//        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
//            @Override
//            public void handleOnBackPressed() {
//                // Handle the back button event
//            }
//        };
//        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
//
//        // The callback can be enabled or disabled here or in handleOnBackPressed()
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_food_tab1, container, false);

        recyclerView = rootView.findViewById(R.id.recyclerView);
        initView();

        return rootView;
    }


    private void initView() {
        GridLayoutManager layoutManager = new GridLayoutManager(this.getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerAdapter adapter = new RecyclerAdapter(itemsList);
        recyclerView.setAdapter(adapter);
    }

    private void initItems() {
        itemsList.add(new RecyclerItem("Korean", "Hwangsaengga", "Jongno-gu", getString(R.string.food_Hwangsaengga_address), 37.58015809025108, 126.98064099768929, getString(R.string.food_Hwangsaengga_description), R.drawable.food_hwangsaengga));
        itemsList.add(new RecyclerItem("Korean", "Wooraeok", "Jung-gu", getString(R.string.food_Wooraeok_address), 37.568217336091884, 126.9987131577966, getString(R.string.food_Wooraeok_description), R.drawable.food_wooraeok));
        itemsList.add(new RecyclerItem("Asian","Tuk Tuk Noodle Thai","Mapo-gu", getString(R.string.food_TukTukNoodleThai_address), 37.56514737979818, 126.92398211118115, getString(R.string.food_TukTukNoodleThai_description), R.drawable.food_tuktuk_noodle_thai));
        itemsList.add(new RecyclerItem("Western","Charles H","Jongno-gu", getString(R.string.food_CharlesH_address), 37.57058617979707, 126.97544321303255, getString(R.string.food_CharlesH_description), R.drawable.food_charles_h));
        itemsList.add(new RecyclerItem("Fusion","Bar Cham","Jongno-gu", getString(R.string.food_BarCham_address), 37.579124605478, 126.97039472039076, getString(R.string.food_BarCham_description), R.drawable.food_bar_cham));
        itemsList.add(new RecyclerItem("Asian","Kojima","Gangnam-gu", getString(R.string.food_Kojima_address), 37.52592321620524, 127.04192450934431, getString(R.string.food_Kojima_description), R.drawable.food_kojima));
        itemsList.add(new RecyclerItem("Fusion","Bawi Pasta Bar","Yongsan-gu", getString(R.string.food_BawiPastaBar_address), 37.53719674808367, 127.00113679216557, getString(R.string.food_BawiPastaBar_description), R.drawable.food_bawi_pasta_bar));
        itemsList.add(new RecyclerItem("Vegan","Maison Jo","Seocho-gu", getString(R.string.food_MaisonJo_address), 37.48194890826757, 127.01010830382059, getString(R.string.food_MaisonJo_description), R.drawable.food_maison_jo));
    }

}