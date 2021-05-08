package com.example.travelpartner;

public class Rider {
    private String from;
    private String to;
    private String adId;
    private String name;
    private String seat;
    private String ride;
    private String date;
    private String DTime;
    private String ATime;
    private String Vm;


    public Rider() {
    }

    public Rider(String from, String to, String adId, String name, String seat, String ride, String date, String DTime, String ATime, String vm) {
        this.from = from;
        this.to = to;
        this.adId = adId;
        this.name = name;
        this.seat = seat;
        this.ride = ride;
        this.date = date;
        this.DTime = DTime;
        this.ATime = ATime;
        this. Vm = vm;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getRide() {
        return ride;
    }

    public void setRide(String ride) {
        this.ride = ride;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDTime() {
        return DTime;
    }

    public void setDTime(String DTime) {
        this.DTime = DTime;
    }

    public String getATime() {
        return ATime;
    }

    public void setATime(String ATime) {
        this.ATime = ATime;
    }

    public String getVm() {
        return Vm;
    }

    public void setVm(String vm) {
        this.Vm = vm;
    }
}
