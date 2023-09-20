package com.example.ziying_assignment1_1551960.ui.bookings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ziying_assignment1_1551960.R;
import com.example.ziying_assignment1_1551960.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class BookingsFragment extends BaseFragment {

    RecyclerView rvFragmentBookings;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_bookings, container, false);
        rvFragmentBookings = rootView.findViewById(R.id.rv_fragmentBookings);
        setupRecyclerView();
        return rootView;
    }

    private void setupRecyclerView() {
        List<BookingsRVItem> bookingsRVItemList = new ArrayList<>();
        // Add some data to this RV list
        bookingsRVItemList.add(new BookingsRVItem("Venosa - Dinner", "Restaurants", "2023-09-05", "5:00 PM", "$20"));
        bookingsRVItemList.add(new BookingsRVItem("Milford Cruise", "Activities", "2023-09-06", "10:00 AM", "$120"));
        bookingsRVItemList.add(new BookingsRVItem("Campervan Rental", "Stay", "2023-09-07", "3:30 PM", "$600"));
        bookingsRVItemList.add(new BookingsRVItem("Winnies Pizza", "Restaurants", "2023-09-08", "11:00 AM", "$30"));
        bookingsRVItemList.add(new BookingsRVItem("Elements Bar", "Restaurants", "2023-09-08", "5:00 PM", "$50"));

        BookingsRVAdapter adapter = new BookingsRVAdapter(bookingsRVItemList);
        rvFragmentBookings.setLayoutManager(new LinearLayoutManager(getContext()));
        rvFragmentBookings.setAdapter(adapter);
    }

    protected void initViews() {
    }

    protected int getLayoutId() {
        return R.layout.fragment_bookings;
    }
}
