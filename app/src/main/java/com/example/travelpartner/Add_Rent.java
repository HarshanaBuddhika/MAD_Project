package com.example.travelpartner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Add_Rent extends AppCompatActivity {
    EditText txtId, txtType, txtModel, txtSeats, txtPrice, txtContNo, txtDes;
    Button btnpost;
    DatabaseReference dbRef;
    RentVehicle rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__rent);

        txtId = findViewById(R.id.enterAdId);
        txtType = findViewById(R.id.enterVehicleType);
        txtModel = findViewById(R.id.enterVehicleModel);
        txtSeats = findViewById(R.id.enterAvailableseat);
        txtPrice = findViewById(R.id.enterPrice);
        txtContNo = findViewById(R.id.telenumber);
        txtDes = findViewById(R.id.des);


        btnpost = findViewById(R.id.post);
        rv = new RentVehicle();



        btnpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("RentVehicle");

                try{
                    if(TextUtils.isEmpty(txtId.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty id",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(txtType.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty Type",Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtModel.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty Model",Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtSeats.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty Seats",Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtPrice.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty Price",Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtContNo.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty Contact Number",Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(txtDes.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty Description",Toast.LENGTH_SHORT).show();
                    else{
                        rv.setId(txtId.getText().toString().trim());
                        rv.setVehicleType(txtType.getText().toString().trim());
                        rv.setVehicleModel(txtModel.getText().toString().trim());
                        rv.setAvailableSeats(Integer.parseInt(txtSeats.getText().toString().trim()));
                        rv.setVehiclePrice(txtPrice.getText().toString().trim());
                        rv.setContact(Integer.parseInt(txtContNo.getText().toString().trim()));
                        rv.setDescription(txtDes.getText().toString().trim());
                        dbRef.child("R1").setValue(rv);
                        Toast.makeText(getApplicationContext(),"Succeessfulyy inserted",Toast.LENGTH_SHORT).show();
                        clearControls();
                    }
                }catch (NumberFormatException nfe){
                    Toast.makeText(getApplicationContext(), "Invalid Contact Number",Toast.LENGTH_SHORT).show();
                }

            }
        });

        }

    private void clearControls(){
        txtId.setText("");
        txtType.setText("");
        txtModel.setText("");
        txtSeats.setText("");
        txtPrice.setText("");
        txtContNo.setText("");
        txtDes.setText("");
    }

    public void previous (View view){
        Intent intent=new Intent( this,Rent.class);
        startActivity(intent);
    }
}