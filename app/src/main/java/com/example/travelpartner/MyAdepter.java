package com.example.travelpartner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdepter extends RecyclerView.Adapter<MyAdepter.myviewHolder> {



    private Context context;
    private ArrayList<RentVehicle> rentVehicleData= new ArrayList<>();

    public MyAdepter(Context context, ArrayList<RentVehicle> rentVehicleData) {
        this.context = context;
        this.rentVehicleData = rentVehicleData;
    }

    @NonNull
    @Override
    public myviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicle,parent,false);
        return new myviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewHolder holder, int position) {

        RentVehicle rentVehicleDatas = rentVehicleData.get(position);

        holder.VType.setText(rentVehicleDatas.getVehicleType());
        holder.VModel.setText(rentVehicleDatas.getVehicleModel());
        holder.VSeat.setText(String.valueOf(rentVehicleDatas.getAvailableSeats()));
        holder.VPrice.setText(rentVehicleDatas.getVehiclePrice());
       holder.VContact.setText(String.valueOf(rentVehicleDatas.getContact()));
        holder.VDes.setText(rentVehicleDatas.getDescription());

    }

    @Override
    public int getItemCount() {
        return rentVehicleData.size();
    }

    public static class myviewHolder extends RecyclerView.ViewHolder {

        TextView VType,VModel,VSeat,VPrice,VContact,VDes;

        public myviewHolder(@NonNull View itemView) {
            super(itemView);

            VType = itemView.findViewById(R.id.VType);
            VModel = itemView.findViewById(R.id.VModel);
            VSeat = itemView.findViewById(R.id.VSeats);
            VPrice = itemView.findViewById(R.id.VPrice);
            VContact = itemView.findViewById(R.id.VContact);
            VDes = itemView.findViewById(R.id.VDes);
        }
    }
}
