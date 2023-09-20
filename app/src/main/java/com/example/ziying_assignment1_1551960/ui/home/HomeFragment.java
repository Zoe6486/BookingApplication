package com.example.ziying_assignment1_1551960.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ziying_assignment1_1551960.R;
import com.example.ziying_assignment1_1551960.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment {
    RecyclerView rvFragmentHome;
    SearchView searchView;

    List<HomeRVItem> homeRVItemList;
    HomeRVAdapter adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the fragment_home layout
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rvFragmentHome = view.findViewById(R.id.rv_fragmentHome);
        searchView = view.findViewById(R.id.searchView);

        // Initialize the list of HomeRVItems and set up the RecyclerView
        homeRVItemList = new ArrayList<>();
        homeRVItemList.add(new HomeRVItem("Milford Sound Nature Cruise", "Category: Activities", "Available from 40% Off", "79", R.drawable.img_home_activity1));
        homeRVItemList.add(new HomeRVItem("Helicopter & Ski Plane Flight", "Category: Activities", "Available from 30% Off", "223", R.drawable.img_home_activity2));
        homeRVItemList.add(new HomeRVItem("Milford Sound Cruise", "Category: Activities", "Available from 35% Off", "185", R.drawable.img_home_activity3));
        adapter = new HomeRVAdapter(homeRVItemList);
        rvFragmentHome.setLayoutManager(new LinearLayoutManager(getContext()));
        rvFragmentHome.setAdapter(adapter);

        // Set up the search functionality according to keywords
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Filter data based on search query
                filterData(newText);
                return true;
            }
        });

        Button btnActivities = view.findViewById(R.id.btn_Activities);
        Button btnRestaurants = view.findViewById(R.id.btn_Restaurants);
        Button btnStay = view.findViewById(R.id.btn_Stay);

        // When btnActivities clicked, display activities
        btnActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Clear the List first
                homeRVItemList.clear();
                // Add some activity data
                homeRVItemList.add(new HomeRVItem("Milford Sound Nature Cruise", "Category: Activities", "Available from 40% Off", "79", R.drawable.img_home_activity1));
                homeRVItemList.add(new HomeRVItem("Helicopter & Ski Plane Flight", "Category: Activities", "Available from 30% Off", "223", R.drawable.img_home_activity2));
                homeRVItemList.add(new HomeRVItem("Milford Sound Cruise", "Category: Activities", "Available from 35% Off", "85", R.drawable.img_home_activity3));

                adapter = new HomeRVAdapter(homeRVItemList);
                rvFragmentHome.setLayoutManager(new LinearLayoutManager(getContext()));
                rvFragmentHome.setAdapter(adapter);
            }
        });

        // When btnRestaurants clicked, display restaurants
        btnRestaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear the List first
                homeRVItemList.clear();
                // Add some restaurant data
                homeRVItemList.add(new HomeRVItem("Winnies Pizza", "Category: Restaurants", "Available from 25% Off", "39", R.drawable.img_home_restaurant1));
                homeRVItemList.add(new HomeRVItem("The Dish - Dinner", "Category: Restaurants", "Available from 33% Off", "23", R.drawable.img_home_restaurant2));
                homeRVItemList.add(new HomeRVItem("Venosa - Dinner", "Category: Restaurants", "Available from 30% Off", "25", R.drawable.img_home_restaurant3));

                adapter = new HomeRVAdapter(homeRVItemList);
                rvFragmentHome.setLayoutManager(new LinearLayoutManager(getContext()));
                rvFragmentHome.setAdapter(adapter);
            }
        });

        // When btnStay clicked, display stays
        btnStay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear the List first
                homeRVItemList.clear();
                // Add some stay data
                homeRVItemList.add(new HomeRVItem("10 Day Campervan Rental", "Category: Stay", "Available from 40% Off", "599", R.drawable.img_home_stay1));
                homeRVItemList.add(new HomeRVItem("3 Day Campervan Relocation Rental", "Category: Stay", "Available from 20% Off", "299", R.drawable.img_home_stay2));

                adapter = new HomeRVAdapter(homeRVItemList);
                rvFragmentHome.setLayoutManager(new LinearLayoutManager(getContext()));
                rvFragmentHome.setAdapter(adapter);
            }
        });

        return view;
    }

    //create a method to filter data when search based on keywords
    private void filterData(String query) {
        List<HomeRVItem> filteredList = new ArrayList<>();
        for (HomeRVItem item : homeRVItemList) {
            if (item.getName().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(item);
            }
        }
        adapter.setData(filteredList);
    }

    @Override
    protected void initViews() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }
}
