package com.example.travelpartner;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class rentlist extends AppCompatActivity {
   private  RecyclerView recyclerView;
   private DatabaseReference dbRef;
   private MyAdepter myAdepter;
   private ArrayList<RentVehicle> rentVehicleData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rentlist);


        recyclerView = findViewById(R.id.rentList);


        rentVehicleData = new ArrayList<RentVehicle>();

        dbRef = FirebaseDatabase.getInstance().getReference("RentVehicle");

        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChildren()){
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        RentVehicle rentVehicle = new RentVehicle();
                        rentVehicle.setVehicleType(dataSnapshot.child("vehicleType").getValue().toString());
                        rentVehicle.setVehicleModel(dataSnapshot.child("vehicleModel").getValue().toString());
                        rentVehicle.setAvailableSeats(Integer.parseInt(dataSnapshot.child("availableSeats").getValue().toString()));
                        rentVehicle.setContact(Integer.parseInt(dataSnapshot.child("contact").getValue().toString()));
                        rentVehicle.setDescription(dataSnapshot.child("description").getValue().toString());
                        rentVehicle.setVehiclePrice(dataSnapshot.child("vehiclePrice").getValue().toString());
                        rentVehicleData.add(rentVehicle);
                    }

                    myAdepter = new MyAdepter(rentlist.this, rentVehicleData);
                    recyclerView.setAdapter(myAdepter);
                    myAdepter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    }


}