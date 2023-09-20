package com.example.ziying_assignment1_1551960.ui.favorite;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ziying_assignment1_1551960.R;

public class FavoriteRVHolder extends RecyclerView.ViewHolder {
    CardView cvFavorite;
    TextView tvName, tvCategory, tvDiscount, tvPrice;
    ImageView ivService;

    Button btnRemove, btnDetails;

    public FavoriteRVHolder(@NonNull View itemView) {
        super(itemView);
        cvFavorite = itemView.findViewById(R.id.cv_favorite);
        tvName = itemView.findViewById(R.id.tv_name);
        tvCategory = itemView.findViewById(R.id.tv_category);
        tvDiscount = itemView.findViewById(R.id.tv_discount);
        tvPrice = itemView.findViewById(R.id.tv_price);
        ivService = itemView.findViewById(R.id.iv_service);
        btnRemove = itemView.findViewById(R.id.btn_remove);
        btnDetails= itemView.findViewById(R.id.btn_details);
    }

}

