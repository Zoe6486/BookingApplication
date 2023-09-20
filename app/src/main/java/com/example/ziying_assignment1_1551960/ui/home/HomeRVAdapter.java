package com.example.ziying_assignment1_1551960.ui.home;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ziying_assignment1_1551960.DealDetails;
import com.example.ziying_assignment1_1551960.R;

import java.util.List;

public class HomeRVAdapter extends RecyclerView.Adapter<HomeRVHolder> {
    private List<HomeRVItem> homeRVItemList;

    public HomeRVAdapter(List<HomeRVItem> homeRVItemList) {
        this.homeRVItemList = homeRVItemList;
    }

    @NonNull
    @Override
    public HomeRVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_home_rvitem, parent, false);
        return new HomeRVHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeRVHolder holder, int position) {
        HomeRVItem rvItem = homeRVItemList.get(position);
        holder.tvName.setText(rvItem.getName());
        holder.tvCategory.setText(rvItem.getCategory());
        holder.tvDiscount.setText(rvItem.getDiscount());
        holder.tvPrice.setText(rvItem.getPrice());
        holder.ivService.setImageResource(rvItem.getImageResourceId());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DealDetails.class);
                intent.putExtra("name", rvItem.getName());
                intent.putExtra("category", rvItem.getCategory());
                intent.putExtra("discount", rvItem.getDiscount());
                intent.putExtra("price", rvItem.getPrice());
                intent.putExtra("imageId", rvItem.getImageResourceId());
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return homeRVItemList.size();
    }

    // Create a method to change data in the list when searching based on keywords
    public void setData(List<HomeRVItem> filteredList) {
        homeRVItemList.clear();
        homeRVItemList.addAll(filteredList);
        notifyDataSetChanged();
    }
}
