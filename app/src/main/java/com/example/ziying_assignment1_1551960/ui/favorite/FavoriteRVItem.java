package com.example.ziying_assignment1_1551960.ui.favorite;

import android.widget.Button;

public class FavoriteRVItem {
    private String name;
    private String category;
    private String discount;
    private String price;
    private int imageResourceId;

    public FavoriteRVItem(String name, String category, String discount, String price, int imageResourceId) {
        this.name = name;
        this.category = category;
        this.discount = discount;
        this.price = price;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDiscount() { return discount; }

    public String getPrice() {
        return price;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
