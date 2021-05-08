package com.example.travelpartner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    EditText Fname, Lname, Email, phone, Pass;
    Button Reg;
    TextView HAcc;
    DatabaseReference Dbc;
    PassengerDB pasDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        Fname = findViewById(R.id.editTextTextPersonName10);
        Lname = findViewById(R.id.editTextTextPersonName11);
        Email = findViewById(R.id.editTextTextEmailAddress2);
        phone = findViewById(R.id.editTextPhone);
        Pass = findViewById(R.id.editTextTextPersonName14);

        Reg = findViewById(R.id.button5);
        HAcc = findViewById(R.id.textgoLogin);

        pasDB = new PassengerDB();

        Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dbc = FirebaseDatabase.getInstance().getReference().child("PassengerDB");
                try {
                    if (TextUtils.isEmpty(Fname.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "First Name is Empty", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(Lname.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Last Name is Empty", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(Email.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Email is Blank", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(phone.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Phone Number is Blank", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(Pass.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Password iS Empty", Toast.LENGTH_SHORT).show();
                    } else {
                        pasDB.setFname(Fname.getText().toString().trim());
                        pasDB.setLname(Lname.getText().toString().trim());
                        pasDB.setEmail(Email.getText().toString().trim());
                        pasDB.setPhone(phone.getText().toString().trim());
                        pasDB.setPassword(Pass.getText().toString().trim());

                        Dbc.child("Test").setValue(pasDB);
                        Toast.makeText(getApplicationContext(), "Data Saved Successfully", Toast.LENGTH_SHORT).show();
                    }


                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Invalide Contact Number", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }

}