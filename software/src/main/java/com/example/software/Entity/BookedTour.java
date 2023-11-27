package com.example.software.Entity;

public class BookedTour {
    private int bookedTourID;
    private int guideuserID;
    private int touristID;
    private String time;
    private int amountOfPeople;
    private int tourID;

    public BookedTour() {
    }

    public BookedTour(int bookedTourID, int guideuserID, int touristID, String time, int amountOfPeople, int tourID) {
        this.bookedTourID = bookedTourID;
        this.guideuserID = guideuserID;
        this.touristID = touristID;
        this.time = time;
        this.amountOfPeople = amountOfPeople;
        this.tourID = tourID;
    }

    public int getTourID() {
        return tourID;
    }

    public void setTourID(int tourID) {
        this.tourID = tourID;
    }

    public int getBookedTourID() {
        return bookedTourID;
    }

    public void setBookedTourID(int bookedTourID) {
        this.bookedTourID = bookedTourID;
    }

    public int getGuideuserID() {
        return guideuserID;
    }

    public void setGuideuserID(int guideuserID) {
        this.guideuserID = guideuserID;
    }

    public int getTouristID() {
        return touristID;
    }

    public void setTouristID(int touristID) {
        this.touristID = touristID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getAmountOfPeople() {
        return amountOfPeople;
    }

    public void setAmountOfPeople(int amountOfPeople) {
        this.amountOfPeople = amountOfPeople;
    }
}
