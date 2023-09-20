package com.example.ziying_assignment1_1551960.ui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.ziying_assignment1_1551960.R;
import com.example.ziying_assignment1_1551960.ui.base.BaseActivity;
import com.example.ziying_assignment1_1551960.ui.favorite.FavoriteFragment;
import com.example.ziying_assignment1_1551960.ui.favorite.FavoriteRVItem;
import com.example.ziying_assignment1_1551960.ui.home.HomeFragment;
import com.example.ziying_assignment1_1551960.ui.my.MyFragment;
import com.example.ziying_assignment1_1551960.ui.bookings.BookingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class CustomerSearch extends BaseActivity implements NavigationBarView.OnItemSelectedListener {

    private Fragment[] fragments;
    private int lastFragmentIndex = 0;
    String favoriteName, favoriteCategory, favoriteDiscount, favoritePrice;
    int favoriteImageId;
    String email, password;

    boolean isSupplierSelected;

    // Use a static list in parent(this) activity to store favorites in case of the short life cycle of list in fragment
    public static List<FavoriteRVItem> favoriteDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_Ziying_Assignment1_1551960);
        super.onCreate(savedInstanceState);

        //Retrieves user-related data from a SharedPreferences file
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        email = sharedPreferences.getString("email", "");
        password = sharedPreferences.getString("password", "");
        isSupplierSelected = sharedPreferences.getBoolean("isSupplierSelected", false);

        Intent intent = getIntent();
        if (intent != null) {
            favoriteName = intent.getStringExtra("favoriteName");
            favoriteCategory = intent.getStringExtra("favoriteCategory");
            favoriteDiscount = intent.getStringExtra("favoriteDiscount");
            favoriteImageId = intent.getIntExtra("favoriteImageId", 0);
            favoritePrice = intent.getStringExtra("favoritePrice");
        }

        if (favoriteName != null && favoriteCategory != null && favoriteDiscount != null && favoritePrice != null)
        {
            //Add favorite to this static list to store
            favoriteDataList.add(new FavoriteRVItem(favoriteName, favoriteCategory, favoriteDiscount, favoritePrice, favoriteImageId));
        }
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_customer_search;
    }

    @Override
    protected void initViews() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavView);
        bottomNavigationView.setOnItemSelectedListener(this);

        //Reference: https://www.bilibili.com/video/BV1tY41187fi?p=6&spm_id_from=pageDriver&vd_source=f5f3d58d9edd57f53b4fc59eb37cacdd
        // Initialize the array of fragments
        fragments = new Fragment[]{new HomeFragment(),
                new FavoriteFragment(),
                new BookingsFragment(),
                new MyFragment()
        };
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.search_frame, fragments[0])
                .commit();
    }

    // Change fragment when clicked different bottom button
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        item.setChecked(true);
        if (item.getItemId() == R.id.bottom_home) {
            switchFragment(0);
        } else if (item.getItemId() == R.id.bottom_favorite) {
            switchFragment(1);
        } else if (item.getItemId() == R.id.bottom_bookings) {
            switchFragment(2);
        } else if (item.getItemId() == R.id.bottom_my) {
            switchFragment(3);
        }
        return false;
    }

    // Reference: https://www.bilibili.com/video/BV1tY41187fi?p=6&spm_id_from=pageDriver&vd_source=f5f3d58d9edd57f53b4fc59eb37cacdd
    private void switchFragment(int to) {
        if (lastFragmentIndex == to) {
            return;
        }
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction();
        if (!fragments[to].isAdded()) {
            fragmentTransaction.add(R.id.search_frame, fragments[to]);
        } else {
            fragmentTransaction.show(fragments[to]);
        }

        // pass some data to MyFragment
        if (fragments[to] instanceof MyFragment) {
            //when MyFragment
            Bundle bundle = new Bundle();
            if (email != null && password != null) {
                bundle.putString("email", email);
                bundle.putString("password", password);
                bundle.putBoolean("isSupplierSelected", isSupplierSelected);
                ((MyFragment) fragments[to]).setArguments(bundle);

            }
        }

        fragmentTransaction.hide(fragments[lastFragmentIndex]).commitAllowingStateLoss();
        lastFragmentIndex = to;
    }

    // create a method for other activity to get this static list
    public static List<FavoriteRVItem> getFavoriteDataList() {
        return favoriteDataList;
    }
}