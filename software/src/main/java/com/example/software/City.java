package com.example.software;

public class City {
    private int cityID;
    private String city;
    private int  city_countryID;
    private String city_picture;

    public City() {
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCity_countryID() {
        return city_countryID;
    }

    public void setCity_countryID(int city_countryID) {
        this.city_countryID = city_countryID;
    }

    public String getCity_picture() {
        return city_picture;
    }

    public void setCity_picture(String city_picture) {
        this.city_picture = city_picture;
    }
}
