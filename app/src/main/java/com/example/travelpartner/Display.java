package com.example.travelpartner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.travelpartner.Rider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Display extends AppCompatActivity {

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("User");

    EditText txtFrom, txtTo, txtAdId, txtName, txtSeat, txtRide, txtDate, txtDTime, txtATime, txtVm;
    Button search,update,delete;
    String SID;
    Rider rid;

    Rider rdisplay;
    Rider rupdate;
    Rider rdelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        txtFrom = findViewById(R.id.TpFrom);
        txtTo = findViewById(R.id.TpTo);
        txtAdId = findViewById(R.id.TpAdId);
        txtName = findViewById(R.id.TpName);
        txtSeat = findViewById(R.id.TpSeat);
        txtRide = findViewById(R.id.TpRide);
        txtDate = findViewById(R.id.TpDate);
        txtDTime = findViewById(R.id.TpDepTime);
        txtATime = findViewById(R.id.TpATime);
        txtVm = findViewById(R.id.TpVModel);

        search=findViewById(R.id.sbtn_search);
        update=findViewById(R.id.sbtn_update);
        delete=findViewById(R.id.sbtn_delete);

        rid = new Rider();


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtAdId=findViewById(R.id.v_adid);
                rdisplay.setAdId(txtAdId.getText().toString());
                SID=rdisplay.getAdId();

                DatabaseReference sdisplay= FirebaseDatabase.getInstance().getReference().child("Sharing").child(SID);
                sdisplay.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChildren())
                        {
                            txtFrom.setText(snapshot.child("From").getValue().toString());
                            txtTo.setText(snapshot.child("To").getValue().toString());
                            txtAdId.setText(snapshot.child("advertistmentID").getValue().toString());
                            txtName.setText(snapshot.child("Name").getValue().toString());
                            txtSeat.setText(snapshot.child("Available seats").getValue().toString());
                            txtRide.setText(snapshot.child("Total cost").getValue().toString());
                            txtDate.setText(snapshot.child("Date").getValue().toString());
                            txtDTime.setText(snapshot.child("Departure Time").getValue().toString());
                            txtATime.setText(snapshot.child("Arrival Time").getValue().toString());
                            txtVm.setText(snapshot.child("Vehical Model").getValue().toString());
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"There is No sharing ride regarding this ID",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtAdId=findViewById(R.id.v_adid);
                rdisplay.setAdId(txtAdId.getText().toString());
                SID=rdisplay.getAdId();

                DatabaseReference rupdate= FirebaseDatabase.getInstance().getReference().child("Sharing");

                try{

                    if(TextUtils.isEmpty(txtFrom.getText().toString()))
                    {

                    }
                    else if(TextUtils.isEmpty(txtTo.getText().toString()))
                    {

                    }
                    else if(TextUtils.isEmpty(txtAdId.getText().toString()))
                    {

                    }
                    else if(TextUtils.isEmpty(txtName.getText().toString()))
                    {

                    }
                    else if(TextUtils.isEmpty(txtSeat.getText().toString()))
                    {

                    }
                    else if(TextUtils.isEmpty(txtRide.getText().toString()))
                    {

                    }
                    else if(TextUtils.isEmpty(txtDate.getText().toString()))
                    {

                    }
                    else if(TextUtils.isEmpty(txtDTime.getText().toString()))
                    {

                    }
                    else if(TextUtils.isEmpty(txtATime.getText().toString()))
                    {

                    }
                    else
                    {
                        rid.setFrom(txtFrom.getText().toString().trim());
                        rid.setTo(txtTo.getText().toString().trim());
                        rid.setAdId(txtAdId.getText().toString().trim());
                        rid.setName(txtName.getText().toString().trim());
                        rid.setSeat(txtSeat.getText().toString().trim());
                        rid.setRide(txtRide.getText().toString().trim());
                        rid.setDate(txtDate.getText().toString().trim());
                        rid.setDTime(txtDTime.getText().toString().trim());
                        rid.setATime(txtATime.getText().toString().trim());
                        rid.setVm(txtVm.getText().toString().trim());

                        rupdate.child(SID).setValue(rdisplay);
                        Toast.makeText(getApplicationContext(),"Update Was Successful",Toast.LENGTH_SHORT).show();


                    }

                }catch (NumberFormatException e)
                {
                    Toast.makeText(getApplicationContext(),"Enter a valid Contact No",Toast.LENGTH_SHORT).show();
                }

            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtAdId=findViewById(R.id.v_adid);
                rdisplay.setAdId(txtAdId.getText().toString());
                SID=rdisplay.getAdId();
                DatabaseReference rdelete=FirebaseDatabase.getInstance().getReference().child("Sharing").child(SID);
                rdelete.removeValue();
                Toast.makeText(getApplicationContext(),"Booking Deleted Successfully",Toast.LENGTH_SHORT).show();
                clearControls();
            }
        });
    }

    public void clearControls()
    {

        txtFrom.setText("");
        txtTo.setText("");
        txtAdId.setText("");
        txtName.setText("");
        txtSeat.setText("");
        txtRide.setText("");
        txtDate.setText("");
        txtDTime.setText("");
        txtATime.setText("");
        txtVm.setText("");


    }

}