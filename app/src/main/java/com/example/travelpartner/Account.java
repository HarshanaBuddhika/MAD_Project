package com.example.travelpartner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Account extends AppCompatActivity {
    private TextView textView;
    View Reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        Reg = findViewById(R.id.txtlogin);

        BottomNavigationView btmnavi=findViewById(R.id.bottom_navigation);

        btmnavi.setSelectedItemId(R.id.account);

        btmnavi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return  true;

                    case R.id.account:
                        return  true;

                    /*case R.id.booking:
                        startActivity(new Intent(getApplicationContext(),Booking_Home.class));
                        overridePendingTransition(0,0);
                        return  true;*/

                    case R.id.rent:
                        startActivity(new Intent(getApplicationContext(),Rent.class));
                        overridePendingTransition(0,0);
                        return  true;

                    case R.id.share:
                        startActivity(new Intent(getApplicationContext(),Share.class));
                        overridePendingTransition(0,0);
                        return  true;
                }

                return false;
            }
        });
        Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Account.this, login01.class);
                startActivity(i);
                finish();
            }
        });


    }

}







