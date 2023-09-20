package com.example.ziying_assignment1_1551960;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    RadioButton rBtnCustomer, rBtnSupplier, rBtnAdmin;
    Button btnNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        rBtnCustomer = findViewById(R.id.rBtn_customer);
        rBtnSupplier = findViewById(R.id.rBtn_supplier);
        rBtnAdmin = findViewById(R.id.rBtn_admin);
        btnNext = findViewById(R.id.btn_next);

//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if (rBtnCustomer.isChecked()) {
//                    return;
//                } else if (rBtnSupplier.isChecked()) {
//                    //showToast("Selected: Supplier");
//                } else if (rBtnAdmin.isChecked()) {
//                    //showToast("Selected: Admin");
//                }
//            }
//        });
    }
    public void btnNextClicked(View view) {
        if(rBtnCustomer.isChecked()){
            Intent intent = new Intent(this, CustomerLogin.class);
            startActivity(intent);
            return;
        }
        else if(rBtnSupplier.isChecked()) {
            Intent intent = new Intent(this, SupplierLogin.class);
            startActivity(intent);
            return;
        }
        else{
            Intent intent = new Intent(this, AdminLogin.class);
            startActivity(intent);
            return;
        }
    }
}