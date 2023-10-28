package com.example.software.Entity;

public class BookedTour {
    private int bookedTourID;
    private int guideuserID;
    private int touristID;
    private String time;
    private int amountOfPeople;

    public BookedTour() {
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
