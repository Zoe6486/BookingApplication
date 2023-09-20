package com.example.ziying_assignment1_1551960;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SupplierSignup extends AppCompatActivity {

    EditText txtUsername, txtLocation, txtEmail, txtPassword, txtConfirmPassword;
    Button btnSignUp, btnGoToLogIn;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_signup);

        txtUsername = findViewById(R.id.txt_companyName);
        txtLocation = findViewById(R.id.txt_location);
        txtEmail = findViewById(R.id.txt_email);
        txtPassword = findViewById(R.id.txt_password);
        txtConfirmPassword = findViewById(R.id.txt_confirmPassword);
        btnSignUp = findViewById(R.id.btn_signUp);
        btnGoToLogIn = findViewById(R.id.btn_goToLogIn);
    }

    public void btnSignUpClicked(View view) {
        if (txtUsername.getText().toString().isEmpty() ||
                txtLocation.getText().toString().isEmpty() ||
                txtEmail.getText().toString().isEmpty() ||
                txtPassword.getText().toString().isEmpty() ||
                txtConfirmPassword.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter all data", Toast.LENGTH_SHORT).show();
        }
        // Make the ConfirmPassword same as password
        else if (!txtConfirmPassword.getText().toString().equals(txtPassword.getText().toString())) {
            Toast.makeText(this, "The password is different.", Toast.LENGTH_SHORT).show();
        } else if (!txtEmail.getText().toString().matches(emailPattern)) {
            Toast.makeText(this, "Invalid email address.", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, SupplierLogin.class);
            try {
                startActivity(intent);
                Toast.makeText(this, "Sign up successfully and you can log in now!", Toast.LENGTH_SHORT).show();
            } catch (ActivityNotFoundException e) {
                Log.e("SupplierLogin", "Activity not found: " + e.getMessage());
                Toast.makeText(this, "Error: Activity not found", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void btnGoToLogInClicked(View view) {
        Intent intent = new Intent(this, SupplierLogin.class);
        startActivity(intent);
    }
}