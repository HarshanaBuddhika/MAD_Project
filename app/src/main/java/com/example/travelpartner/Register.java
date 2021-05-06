package com.example.travelpartner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText Fname, Lname, Email, phone, Pass;
    Button Reg;
    TextView HAcc;

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

        Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FName,LName,email,Phone,pass;

                FName = Fname.getText().toString();
                LName = Lname.getText().toString();
                email = Email.getText().toString();
                Phone = phone.getText().toString();
                pass = Pass.getText().toString();

                if(FName.equals("")){
                    Toast.makeText(Register.this, "First Name is Empty", Toast.LENGTH_LONG).show();
                }
                if(LName.equals("")){
                    Toast.makeText(Register.this, "Last Name is Empty", Toast.LENGTH_LONG).show();
                }
                if(email.equals("")){
                    Toast.makeText(Register.this, "Email is Blank", Toast.LENGTH_LONG).show();
                }
                if(Phone.equals("")){
                    Toast.makeText(Register.this, "Phone Number is Blank", Toast.LENGTH_LONG).show();
                }
                if(pass.equals("")){
                    Toast.makeText(Register.this, "Password iS Empty", Toast.LENGTH_LONG).show();
                }



            }
        });
        Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Register.this,login01.class);
                startActivity(i);
                finish();
            }
        });
    }
}