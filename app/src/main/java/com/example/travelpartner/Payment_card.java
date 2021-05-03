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

public class Payment_card extends AppCompatActivity {

    EditText name,uid,bid,amount,cardNumber,cardName,expDate, cards;
    Button cardPayment;
    String paymentID;

    DatabaseReference databaseReference;

    Payments pay;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_card);

        name=findViewById(R.id.payment_name);
        uid=findViewById(R.id.payment_uid);
        bid=findViewById(R.id.payment_bid);
        amount=findViewById(R.id.payment_amount);
        cardNumber=findViewById(R.id.payment_cname);
        cardName=findViewById(R.id.payment_nameinc);
        expDate=findViewById(R.id.payment_year);
        cards =findViewById(R.id.payment_csv);

        cardPayment=findViewById(R.id.btn_cardpayment);

        pay=new Payments();

        cardPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                databaseReference=FirebaseDatabase.getInstance().getReference().child("CardPayments");

                try {

                    if(TextUtils.isEmpty(name.getText().toString()))
                    {

                    }
                    else if(TextUtils.isEmpty(uid.getText().toString()))
                    {

                    }
                    else if(TextUtils.isEmpty(bid.getText().toString()))
                    {

                    }
                    else if(TextUtils.isEmpty(amount.getText().toString()))
                    {

                    }
                    else if(TextUtils.isEmpty(cardNumber.getText().toString()))
                    {

                    }
                    else if(TextUtils.isEmpty(cardName.getText().toString()))
                    {

                    }
                    else if(TextUtils.isEmpty(expDate.getText().toString()))
                    {

                    }

                    else
                    {
                        pay.setName(name.getText().toString().trim());
                        pay.setUid(uid.getText().toString().trim());
                        pay.setBid(bid.getText().toString().trim());
                        pay.setAmount(Double.parseDouble(amount.getText().toString().trim()));
                        pay.setCnumber(Integer.parseInt(cardNumber.getText().toString().trim()));
                        pay.setOwoname(cardName.getText().toString().trim());
                        pay.setExp(expDate.getText().toString().trim());
                        pay.setCsv(Integer.parseInt(cards.getText().toString().trim()));

                        paymentID=pay.getBid()+pay.getUid();

                        databaseReference.child(paymentID).setValue(pay);

                        Toast.makeText(getApplicationContext(),"Payment Was successfull",Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(),"Your Payment ID is your Booking ID + User ID",Toast.LENGTH_LONG).show();
                        clearFeilds1();

                    }
                }catch (NumberFormatException e)
                {
                    Toast.makeText(getApplicationContext(),"Enter A valid CVS",Toast.LENGTH_SHORT).show();
                }


            }

        });
    }

    public void clearFeilds1()
    {
        name.setText("");
        uid.setText("");
        bid.setText("");
        amount.setText("");
        cardNumber.setText("");
        cardName.setText("");
        expDate.setText("");
        cards.setText("");
    }


}