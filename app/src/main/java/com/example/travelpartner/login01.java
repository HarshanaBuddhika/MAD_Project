package com.example.travelpartner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login01 extends AppCompatActivity {
    EditText email,pass;
    Button loging;
    TextView btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login01);

        email = findViewById(R.id.editTextTextPersonName);
        pass = findViewById(R.id.editTextTextPassword);

        loging = findViewById(R.id.button4);
        btn = findViewById(R.id.textView11);

        loging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail,pas;

                        mail = email.getText().toString();
                        pas = pass.getText().toString();

                        if(mail.equals("")){
                            Toast.makeText(login01.this, "Email is Blank", Toast.LENGTH_LONG).show();
                        }


                        else if(pas.equals("")) {
                            Toast.makeText(login01.this, "Password is Blnak", Toast.LENGTH_LONG).show();
                        }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(login01 .this,Register.class);
                startActivity(i);
                finish();
            }
        });


    }
}