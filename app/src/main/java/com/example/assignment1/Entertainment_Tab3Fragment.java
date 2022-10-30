package com.example.assignment1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class Entertainment_Tab3Fragment extends Fragment {

    RecyclerView recyclerView;
    List<RecyclerItem> itemsList = new ArrayList<>();



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initItems();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_entertainment_tab3, container, false);

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
        itemsList.add(new RecyclerItem("Coffee", "aaa", "district1", R.drawable.image1));
        itemsList.add(new RecyclerItem("Coffee", "bbb", "district2", R.drawable.image2));
        itemsList.add(new RecyclerItem("Coffee","ccc","district3", R.drawable.image3));
        itemsList.add(new RecyclerItem("Coffee","ddd","district4", R.drawable.image1));
        itemsList.add(new RecyclerItem("Coffee","eee","district5", R.drawable.image2));
        itemsList.add(new RecyclerItem("Coffee","fff","district6", R.drawable.image3));
        itemsList.add(new RecyclerItem("Restaurant","ggg","district7", R.drawable.image1));
        itemsList.add(new RecyclerItem("Restaurant","hhh","district8", R.drawable.image2));
        itemsList.add(new RecyclerItem("Restaurant","iii","district9", R.drawable.image3));
        itemsList.add(new RecyclerItem("Restaurant","jjj","district10", R.drawable.image1));
        itemsList.add(new RecyclerItem("Restaurant","kkk","district11", R.drawable.image2));
    }


}