package com.example.travelpartner;

public class RentVehicle {


    private String Id;
    private String VehicleType;
    private String VehicleModel;
    private int AvailableSeats;
    private String VehiclePrice;
    private int Contact;
    private String Description;


    public RentVehicle() {
    }






    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getVehicleType() {
        return VehicleType;
    }

    public void setVehicleType(String vehicleType) {
        VehicleType = vehicleType;
    }

    public String getVehicleModel() {
        return VehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        VehicleModel = vehicleModel;
    }

    public int getAvailableSeats() {
        return AvailableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        AvailableSeats = availableSeats;
    }

    public String getVehiclePrice() {
        return VehiclePrice;
    }

    public void setVehiclePrice(String vehiclePrice) {
        VehiclePrice = vehiclePrice;
    }

    public int getContact() {
        return Contact;
    }

    public void setContact(int contact) {
        Contact = contact;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}