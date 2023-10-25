package com.example.software;

public class Tour {
    private int tourID;
    private int guideUserID;
    private int CityID;
    private String description;
    private int price;
    private int maxPeople;
    private String tour_picture;

    public Tour() {
    }

    public int getTourID() {
        return tourID;
    }

    public void setTourID(int tourID) {
        this.tourID = tourID;
    }

    public int getGuideUserID() {
        return guideUserID;
    }

    public void setGuideUserID(int guideUserID) {
        this.guideUserID = guideUserID;
    }

    public int getCityID() {
        return CityID;
    }

    public void setCityID(int cityID) {
        CityID = cityID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getTour_picture() {
        return tour_picture;
    }

    public void setTour_picture(String toru_picture) {
        this.tour_picture = toru_picture;
    }
}
