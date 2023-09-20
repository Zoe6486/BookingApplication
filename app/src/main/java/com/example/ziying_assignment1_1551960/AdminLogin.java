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

import com.example.ziying_assignment1_1551960.ui.CustomerSearch;

public class AdminLogin extends AppCompatActivity {

    String email, password;
    EditText txtEmail, txtPassword;
    Button btnLogIn, btnBackToChoose;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        txtEmail = findViewById(R.id.txt_email);
        txtPassword = findViewById(R.id.txt_password);
        btnLogIn = findViewById(R.id.btn_logIn);
        btnBackToChoose = findViewById(R.id.btn_backToChoose);
    }

    public void btnLogInClicked(View view) {
        email = txtEmail.getText().toString();
        password = txtPassword.getText().toString();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT).show();
        } else if (!txtEmail.getText().toString().matches(emailPattern)) {
            Toast.makeText(this, "Invalid email address.", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, AdminManagement.class);
            intent.putExtra("email", email);
            intent.putExtra("password", password);

            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e) {
                Log.e("AdminLogin", "Activity not found: " + e.getMessage());
                Toast.makeText(this, "Error: Activity not found", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void btnBackToChooseClicked(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}