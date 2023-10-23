package com.example.software;

public class Country {
    private int countryID;
    private String country;
    private String country_picture;

    public Country() {
    }

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry_picture() {
        return country_picture;
    }

    public void setCountry_picture(String country_picture) {
        this.country_picture = country_picture;
    }
}
