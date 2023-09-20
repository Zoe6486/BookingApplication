package com.example.ziying_assignment1_1551960.ui.home;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ziying_assignment1_1551960.CustomerSignup;
import com.example.ziying_assignment1_1551960.R;

public class HomeRVHolder extends RecyclerView.ViewHolder {
    CardView cvHome;
    TextView tvName, tvCategory, tvDiscount, tvPrice;
    ImageView ivService;

    public HomeRVHolder(@NonNull View itemView) {
        super(itemView);
        cvHome = itemView.findViewById(R.id.cv_home);
        tvName = itemView.findViewById(R.id.tv_name);
        tvCategory = itemView.findViewById(R.id.tv_category);
        tvDiscount = itemView.findViewById(R.id.tv_discount);
        tvPrice = itemView.findViewById(R.id.tv_price);
        ivService = itemView.findViewById(R.id.iv_service);

    }

}

