package com.example.travelpartner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class payment_online extends AppCompatActivity {

    EditText name,uid,bid,amount,refNum;
    Button payment;

    String paymentid;

    DatabaseReference dbref2;

    Payments pay2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_online);

        name=findViewById(R.id.payment_name2);
        uid=findViewById(R.id.payment_uid2);
        bid=findViewById(R.id.payment_bid2);
        amount=findViewById(R.id.payment_amount2);
        refNum=findViewById(R.id.payment_refnum);

        payment=findViewById(R.id.btn_onlinepayment);

        pay2=new Payments();

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbref2= FirebaseDatabase.getInstance().getReference().child("OnlinePayments");

                try
                {
                    if(TextUtils.isEmpty(name.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"Enter A valid Name",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(uid.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"Enter A valid User ID",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(bid.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"Enter A valid Booking ID",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(amount.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(),"Enter A valid Amount",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        pay2.setName(name.getText().toString().trim());
                        pay2.setUid(uid.getText().toString().trim());
                        pay2.setBid(bid.getText().toString().trim());
                        pay2.setAmount(Double.parseDouble(amount.getText().toString().trim()));
                        pay2.setReferenceNumber(Integer.parseInt(refNum.getText().toString().trim()));

                        paymentid=pay2.getBid()+pay2.getUid();

                        dbref2.child(paymentid).setValue(pay2);

                        Toast.makeText(getApplicationContext(),"Data Saved Successfully",Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(),"Your Payment ID is your Booking ID + User ID",Toast.LENGTH_LONG).show();
                        clearFeilds2();
                    }

                }catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Enter A valid Reference Number",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void clearFeilds2()
    {
        name.setText("");
        uid.setText("");
        bid.setText("");
        amount.setText("");
        refNum.setText("");
    }
}