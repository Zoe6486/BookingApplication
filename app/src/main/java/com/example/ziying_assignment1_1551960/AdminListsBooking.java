package com.example.ziying_assignment1_1551960;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class AdminListsBooking extends AppCompatActivity {

    Button btnDelete1, btnDelete2;
    CardView cvBooking1, cvBooking2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_lists_booking);
        btnDelete1 = findViewById(R.id.btn_delete1);
        btnDelete2 = findViewById(R.id.btn_delete2);
        cvBooking1 = findViewById(R.id.cv_booking1);
        cvBooking2 = findViewById(R.id.cv_booking2);

        btnDelete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cvBooking1 != null) {
                    ViewGroup parentLayout = (ViewGroup) cvBooking1.getParent();
                    if (parentLayout != null) {
                        parentLayout.removeView(cvBooking1);
                    }
                }

            }
        });

        btnDelete2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Remove item from the list
                if (cvBooking2 != null) {
                    ViewGroup parentLayout = (ViewGroup) cvBooking2.getParent();
                    if (parentLayout != null) {
                        parentLayout.removeView(cvBooking2);
                    }
                }

            }
        });
    }
}