package com.example.travelpartner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

import java.sql.Ref;

public class Add_Rent extends AppCompatActivity {
    EditText txtId, txtType, txtModel, txtSeats, txtPrice, txtContNo, txtDes;
    Button btnpost, btnchoose;
    ImageView img;
    DatabaseReference dbRef;
    StorageReference mStorageRef;
    RentVehicle RentVehicle;
    String Rentid;
    private StorageTask uploadTask;
    public Uri imguri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__rent);

        mStorageRef = FirebaseStorage.getInstance().getReference("Images");
        dbRef = FirebaseDatabase.getInstance().getReference().child("RentVehicle");
        txtId = findViewById(R.id.enterAdId);
        txtType = findViewById(R.id.enterVehicleType);
        txtModel = findViewById(R.id.enterVehicleModel);
        txtSeats = findViewById(R.id.enterAvailableseat);
        txtPrice = findViewById(R.id.enterPrice);
        txtContNo = findViewById(R.id.telenumber);
        txtDes = findViewById(R.id.des);

        btnchoose = findViewById(R.id.ChooseImage);
        btnpost = findViewById(R.id.post);
        img = (ImageView) findViewById(R.id.imgview);
        RentVehicle = new RentVehicle();

        btnchoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Filechooser();
            }
        });
        btnpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (uploadTask !=null && uploadTask.isInProgress())
                {
                    Toast.makeText(Add_Rent.this,"Uploade in progress",Toast.LENGTH_LONG).show();
                }else {
                    Fileuploader();
                }
            }
        });

    }
      private String getExtention(Uri uri)
      {
          ContentResolver cr = getContentResolver();
          MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
          return mimeTypeMap.getExtensionFromMimeType(cr.getType(uri));
      }


        private void Fileuploader ()
        {
            String imageid;
            imageid = System.currentTimeMillis()+"."+getExtention(imguri);
            RentVehicle.setId(txtId.getText().toString().trim());
            RentVehicle.setVehicleType(txtType.getText().toString().trim());
            RentVehicle.setVehicleModel(txtModel.getText().toString().trim());
            int st=Integer.parseInt(txtSeats.getText().toString().trim());
            RentVehicle.setAvailableSeats(st);
            RentVehicle.setVehiclePrice(txtPrice.getText().toString().trim());
            int con = Integer.parseInt(txtContNo.getText().toString().trim());
            RentVehicle.setContact(con);
            RentVehicle.setDescription(txtDes.getText().toString().trim());
            RentVehicle.setImageid(imageid);
            Rentid = RentVehicle.getId();
            dbRef.child(Rentid).setValue(RentVehicle);

            StorageReference ref =mStorageRef.child(imageid);
            clearControls();

            uploadTask =ref.putFile(imguri)
                        .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>(){
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                                //Uri downloadUro = taskSnapshot.DownloadUri();
                                Toast.makeText(Add_Rent.this,"Image Uploaded Succesfully",Toast.LENGTH_LONG).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                
            }
        });

        }

    private void Filechooser () {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(intent, 1);
        }

        @Override
        protected void onActivityResult ( int requestCode, int resultCode, @Nullable Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == 1 && resultCode == RESULT_OK && data!= null && data.getData() != null) {
                imguri = data.getData();
                img.setImageURI(imguri);
            }
        }

    public void previous (View view){
        Intent intent=new Intent( this,Rent.class);
        startActivity(intent);
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
}