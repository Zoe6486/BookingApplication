package com.example.ziying_assignment1_1551960;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ziying_assignment1_1551960.ui.CustomerSearch;
import com.example.ziying_assignment1_1551960.ui.favorite.FavoriteFragment;
import com.example.ziying_assignment1_1551960.ui.favorite.FavoriteRVItem;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class DealDetails extends AppCompatActivity {

    TextView tvName, tvCategory, tvDiscount, tvPriceDetails, tvLocation, tvNotes;
    Button btnBack, btnFavorite, btnBook;
    ImageView ivService;

    String name, category, discount, price ;
    int imageId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deal_details);
        tvName = findViewById(R.id.tv_name);
        tvCategory = findViewById(R.id.tv_category);
        tvDiscount = findViewById(R.id.tv_discount);
        tvPriceDetails = findViewById(R.id.tv_priceDetails);
        tvLocation = findViewById(R.id.tv_location);
        tvNotes = findViewById(R.id.tv_notes);
        btnBack = findViewById(R.id.btn_back);
        btnFavorite = findViewById(R.id.btn_favorite);
        btnBook = findViewById(R.id.btn_book);
        ivService = findViewById(R.id.iv_service);


        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        tvName.setText(name);
        category = intent.getStringExtra("category");
        tvCategory.setText(category);
        discount = intent.getStringExtra("discount");
        tvDiscount.setText(discount);
        imageId = intent.getIntExtra("imageId", 0);
        ivService.setImageResource(imageId);

        price = intent.getStringExtra("price");
        double dbPrice = Double.parseDouble(price);
        double dbHalfPrice = dbPrice / 2.0;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formattedPrice = decimalFormat.format(dbPrice);
        String formattedHalfPrice = decimalFormat.format(dbHalfPrice);
        tvPriceDetails.setText(" Standard(Full Value) Pricing:" +
                "\n   Adult: $"
                + formattedPrice +
                "\n   Child: $"
                + formattedHalfPrice +
                " (4-14 yrs)" +
                "\n   Infant: $0.00 (0-3 yrs)");


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DealDetails.this, CustomerSearch.class);
                startActivity(intent);
            }
        });
        btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DealDetails.this, CustomerSearch.class);
                intent.putExtra("favoriteName", name);
                intent.putExtra("favoriteCategory", category);
                intent.putExtra("favoriteDiscount", discount);
                intent.putExtra("favoritePrice", price);
                intent.putExtra("favoriteImageId", imageId);
                startActivity(intent);
            }
        });
    }

}