package com.example.travelpartner;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Post_Rent extends AppCompatActivity {

    EditText rid,Type,Model,Seats,Price,Contact,Description;
    Button search,update,delete;


    String RID;
    RentVehicle rentdisplay;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post__rent);


        Type= findViewById(R.id.r_Type);
        Model = findViewById(R.id.r_Model);
        Seats= findViewById(R.id.r_Seats);
        Price = findViewById(R.id.r_Price);
        Contact = findViewById(R.id.contact);
        Description = findViewById(R.id.r_Description);

        search = findViewById(R.id.btn_search);
        update=findViewById(R.id.btn_update);
        delete=findViewById(R.id.btn_delete);

        rentdisplay = new RentVehicle();

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rid = findViewById(R.id.r_rid);
                rentdisplay.setRid(rid.getText().toString());
                RID = rentdisplay.getRid();

                DatabaseReference rentdisplay = FirebaseDatabase.getInstance().getReference().child("RentVehicle").child(RID);
                rentdisplay.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.hasChildren())
                        {
                         Type.setText(snapshot.child("VehicleType").getValue().toString());
                         Model.setText(snapshot.child("VehicleModel").getValue().toString());
                         Seats.setText(snapshot.child("AvailableSeats").getValue().toString());
                         Price.setText(snapshot.child("VehiclePrice").getValue().toString());
                         Contact.setText(snapshot.child("Contact").getValue().toString());
                         Description.setText(snapshot.child("description").getValue().toString());
                        }
                        else
                            {
                                Toast.makeText(getApplicationContext(),"There is No Rent Id regarding this ID",Toast.LENGTH_SHORT).show();
                            }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

  }
}
