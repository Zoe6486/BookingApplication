package com.example.ziying_assignment1_1551960.ui.my;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ziying_assignment1_1551960.DealDetails;
import com.example.ziying_assignment1_1551960.MainActivity;
import com.example.ziying_assignment1_1551960.R;
import com.example.ziying_assignment1_1551960.SupplierLogin;
import com.example.ziying_assignment1_1551960.SupplierSale;
import com.example.ziying_assignment1_1551960.SupplierSignup;
import com.example.ziying_assignment1_1551960.ui.CustomerSearch;
import com.example.ziying_assignment1_1551960.ui.base.BaseFragment;
import com.example.ziying_assignment1_1551960.ui.favorite.FavoriteRVItem;

import java.util.List;

public class MyFragment extends BaseFragment {
    Button btnLogout, btnEdit, btnItemsForSale;
    TextView tvCustomerOrSupplier, tvUsername, tvEmail, tvPhone, tvLocation;
    String email, password;
    boolean isSupplierSelected;

    List<FavoriteRVItem> favoriteRVItemList = CustomerSearch.getFavoriteDataList();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);

        tvCustomerOrSupplier = view.findViewById(R.id.tv_customerOrSupplier);
        tvUsername = view.findViewById(R.id.tv_username);
        tvEmail = view.findViewById(R.id.tv_email);
        tvPhone = view.findViewById(R.id.tv_phone);
        tvLocation = view.findViewById(R.id.tv_location);

        btnEdit = view.findViewById(R.id.btn_edit);
        btnLogout = view.findViewById(R.id.btn_logout);
        btnItemsForSale = view.findViewById(R.id.btn_itemsForSale);

        // Get logIn data (email and password) from fragment's parent
        Bundle args = getArguments();
        if (args != null) {
            email = args.getString("email");
            password = args.getString("password");
            // get a boolean data to know the identity of user(Customer or Supplier)
            isSupplierSelected = args.getBoolean("isSupplierSelected");
        }
        // set email data to tvEmail
        tvEmail.setText(email);

        // If the user is  supplier
        if(isSupplierSelected) {
            // Change the username to company name
            tvCustomerOrSupplier.setText("Company/Store: ");
            tvUsername.setText("Sunset Pizza");
            // Make btnItemsForSale visible
            btnItemsForSale.setVisibility(View.VISIBLE);
            btnItemsForSale.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // display supplier's items for sale when btnItemsForSale clicked
                    Intent intent =  new Intent(view.getContext(), SupplierSale.class);
                    startActivity(intent);
                }});

        }


        // When btnEdit clicked, alert a dialog for users to edit his information
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(view.getContext());
                alertDialogBuilder.setTitle("Edit Information");


                // Create a new Linearlayout to this dialog
                LinearLayout layout = new LinearLayout(view.getContext());
                layout.setOrientation(LinearLayout.VERTICAL);

                // Add EditTexts to this dialog for users to change info
                final EditText txtUsername = new EditText(view.getContext());
                if(isSupplierSelected){
                    txtUsername.setHint("Company/Store: " + tvUsername.getText().toString());
                }
                else{
                    txtUsername.setHint("Username: " + tvUsername.getText().toString());
                }
                layout.addView(txtUsername);
                final EditText txtEmail = new EditText(view.getContext());
                txtEmail.setHint("Email: " + tvEmail.getText().toString());
                layout.addView(txtEmail);
                final EditText txtPassword = new EditText(view.getContext());
                txtPassword.setHint("Password: " + password);
                layout.addView(txtPassword);
                final EditText txtPhone = new EditText(view.getContext());
                txtPhone.setHint("Phone: " + tvPhone.getText().toString());
                layout.addView(txtPhone);
                final EditText txtLocation = new EditText(view.getContext());
                txtLocation.setHint("Location: " + tvLocation.getText().toString());
                layout.addView(txtLocation);

                alertDialogBuilder.setView(layout);


                alertDialogBuilder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Get data the user changed to his information
                        String newUsername = txtUsername.getText().toString();
                        String newEmail = txtEmail.getText().toString();
                        String newPassword = txtPassword.getText().toString();
                        String newPhone = txtPhone.getText().toString();
                        String newLocation = txtLocation.getText().toString();

                        if (newUsername.isEmpty() || newEmail.isEmpty() || newPassword.isEmpty() || newPhone.isEmpty() || newLocation.isEmpty()) {
                            Toast.makeText(getContext(), "Please input all data", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        // set data that user saved his changes
                        tvUsername.setText(newUsername);
                        tvEmail.setText(newEmail);
                        tvPhone.setText(newPhone);
                        tvLocation.setText(newLocation);

                        dialog.dismiss();
                    }
                });

                // When clicked Cancel button, no change to his information
                alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });


                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        // When clicked btnLogout, go back to initial page
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //clear My Favorite list when log out
                favoriteRVItemList.clear();
                // Back to main page
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        return view;
    }

    @Override
    protected void initViews() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }
}
