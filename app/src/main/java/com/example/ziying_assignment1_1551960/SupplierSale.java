package com.example.ziying_assignment1_1551960;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SupplierSale extends AppCompatActivity {

    Button btnDelete;
    CardView cvSaleItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_sale);
        btnDelete = findViewById(R.id.btn_delete);
        cvSaleItem = findViewById(R.id.cv_saleItem);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Remove item from the list
                if (cvSaleItem != null) {
                    ViewGroup parentLayout = (ViewGroup) cvSaleItem.getParent();
                    if (parentLayout != null) {
                        parentLayout.removeView(cvSaleItem);
                    }
                }

            }
        });
    }
}