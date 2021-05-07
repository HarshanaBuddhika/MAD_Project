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

public class post extends AppCompatActivity {

     private EditText txtFrom, txtTo, txtAdId, txtName, txtSeat, txtRide, txtDate, txtDTime, txtATime, txtVm;
     private Button butPost;
     DatabaseReference dbRef;
     Rider rid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

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

        butPost = findViewById(R.id.button2);

        rid = new Rider();

        butPost.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dbRef = FirebaseDatabase.getInstance().getReference().child("Rider");
                try{
                    if(TextUtils.isEmpty(txtFrom.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Empty Location", Toast.LENGTH_SHORT).show();
                    }
                    else if (TextUtils.isEmpty(txtTo.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Empty Location", Toast.LENGTH_SHORT).show();
                    }
                    else if (TextUtils.isEmpty(txtAdId.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Empty ID", Toast.LENGTH_SHORT).show();
                    }
                    else if (TextUtils.isEmpty(txtName.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Empty Name", Toast.LENGTH_SHORT).show();
                    }
                    else if (TextUtils.isEmpty(txtSeat.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Empty Seat", Toast.LENGTH_SHORT).show();
                    }
                    else if (TextUtils.isEmpty(txtRide.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Empty Cost for ride", Toast.LENGTH_SHORT).show();
                    }
                    else if (TextUtils.isEmpty(txtDate.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Empty Date", Toast.LENGTH_SHORT).show();
                    }
                    else if (TextUtils.isEmpty(txtDTime.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Empty Departure Time", Toast.LENGTH_SHORT).show();
                    }
                    else if (TextUtils.isEmpty(txtATime.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Empty Arrival Time", Toast.LENGTH_SHORT).show();
                    } 

                    else{
                        rid.setFrom(txtFrom.getText().toString().trim());
                        rid.setTo(txtTo.getText().toString().trim());
                        rid.setAdId(txtAdId.getText().toString().trim());
                        rid.setName(txtName.getText().toString().trim());
                        rid.setSeat(txtSeat.getText().toString().trim());
                        rid.setRide(txtRide.getText().toString().trim());
                        rid.setDate(txtDate.getText().toString().trim());
                        rid.setDTime(txtDTime.getText().toString().trim());
                        rid.setATime(txtATime.getText().toString().trim());
                        rid.setVm(Integer.parseInt(txtVm.getText().toString().trim()));

                        dbRef.child("rider1").setValue(rid);
                        Toast.makeText(getApplicationContext(), "Successfully Inserted", Toast.LENGTH_SHORT).show();
                        clearControls();
                    }
                }
                catch (NumberFormatException nfe){
                    Toast.makeText(getApplicationContext(),"Invalid Vehicle Model", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void clearControls(){
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

    public void button (View view){
        Intent intent =new Intent(this,Share.class);
        startActivity(intent);

    }


}