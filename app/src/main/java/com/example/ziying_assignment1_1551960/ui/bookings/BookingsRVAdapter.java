package com.example.ziying_assignment1_1551960.ui.bookings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ziying_assignment1_1551960.R;

import java.util.List;

public class BookingsRVAdapter extends RecyclerView.Adapter<BookingsRVHolder>{
private List<BookingsRVItem> bookingsRVItemList;
    public BookingsRVAdapter(List<BookingsRVItem> bookingsRVItemList) {
        this.bookingsRVItemList = bookingsRVItemList;
    }
    @NonNull
    @Override
    public BookingsRVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_bookings_rvitem,parent,false);
        return new BookingsRVHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookingsRVHolder holder, int position) {
        // give each RVItem some data
        BookingsRVItem rvItem = bookingsRVItemList.get(position);
        holder.tvServiceName.setText(rvItem.getServiceName());
        holder.tvServiceCategory.setText(rvItem.getServiceCategory());
        holder.tvStartDate.setText(rvItem.getStartDate());
        holder.tvStartTime.setText(rvItem.getStartTime());
        holder.tvPaid.setText(rvItem.getPaid());

    }

    @Override
    public int getItemCount() {
        return bookingsRVItemList.size();
    }
}
