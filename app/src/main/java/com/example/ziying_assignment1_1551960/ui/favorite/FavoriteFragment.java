package com.example.ziying_assignment1_1551960.ui.favorite;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ziying_assignment1_1551960.R;
import com.example.ziying_assignment1_1551960.ui.CustomerSearch;
import com.example.ziying_assignment1_1551960.ui.base.BaseFragment;
import com.example.ziying_assignment1_1551960.DealDetails;


import java.util.ArrayList;
import java.util.List;

public class FavoriteFragment extends BaseFragment {
    RecyclerView rvFragmentFavorite;

    // Get favorite data list from CustomerSearch(parent)
    List<FavoriteRVItem> favoriteRVItemList = CustomerSearch.getFavoriteDataList();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the fragment_favorite layout
        View rootView = inflater.inflate(R.layout.fragment_favorite, container, false);
        rvFragmentFavorite = rootView.findViewById(R.id.rv_fragmentFavorite);

        setupRecyclerView();
        return rootView;
    }

    private void setupRecyclerView() {
        if (!favoriteRVItemList.isEmpty()) {
            // Create an adapter and set it to the RecyclerView
            FavoriteRVAdapter adapter = new FavoriteRVAdapter(favoriteRVItemList);
            rvFragmentFavorite.setLayoutManager(new LinearLayoutManager(getContext()));
            rvFragmentFavorite.setAdapter(adapter);
        } else {
            // Hide RecyclerView when no favorite adds
            rvFragmentFavorite.setVisibility(View.GONE);
        }
    }


    @Override
    protected void initViews() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_favorite;
    }

}
