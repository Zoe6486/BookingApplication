package com.example.ziying_assignment1_1551960;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminManagement extends AppCompatActivity {

    Button btnCustomerLists, btnSupplierLists, btnActivityLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_management);
        btnCustomerLists = findViewById(R.id.btn_customerLists);
        btnSupplierLists = findViewById(R.id.btn_supplierLists);
        btnActivityLists = findViewById(R.id.btn_activityLists);

        btnCustomerLists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminManagement.this, AdminListsCustomer.class );
                startActivity(intent);
            }
        });

        btnSupplierLists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminManagement.this, AdminListsSupplier.class );
                startActivity(intent);
            }
        });

        btnActivityLists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminManagement.this, AdminListsBooking.class );
                startActivity(intent);

            }
        });
    }
}