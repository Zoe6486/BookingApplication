package com.example.ziying_assignment1_1551960.ui.favorite;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ziying_assignment1_1551960.DealDetails;
import com.example.ziying_assignment1_1551960.R;

import java.util.List;

public class FavoriteRVAdapter extends RecyclerView.Adapter<FavoriteRVHolder> {

    private List<FavoriteRVItem> favoriteRVItemList;

    // Constructor to initialize the adapter with a list of favorite items
    public FavoriteRVAdapter(List<FavoriteRVItem> favoriteRVItemList) {
        this.favoriteRVItemList = favoriteRVItemList;
    }

    @NonNull
    @Override
    public FavoriteRVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for a single item view in the RecyclerView
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_favorite_rvitem, parent, false);
        return new FavoriteRVHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteRVHolder holder, int position) {
        // Bind data to the ViewHolder
        FavoriteRVItem rvItem = favoriteRVItemList.get(position);
        holder.tvName.setText(rvItem.getName());
        holder.tvCategory.setText(rvItem.getCategory());
        holder.tvDiscount.setText(rvItem.getDiscount());
        holder.tvPrice.setText(rvItem.getPrice());
        holder.ivService.setImageResource(rvItem.getImageResourceId());

        holder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // when btnRemove Clicked, remove this favorite thing
                int position = holder.getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    removeItem(position);
                    notifyItemRemoved(position);
                }
            }
        });
        holder.btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Go to DealDetails Screen to display details of this favorite
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
        return favoriteRVItemList.size();
    }

    // Create a method to remove favorite item
    public void removeItem(int position) {
        if (position >= 0 && position < favoriteRVItemList.size()) {
            favoriteRVItemList.remove(position);
            notifyItemRemoved(position);
        }
    }


}
