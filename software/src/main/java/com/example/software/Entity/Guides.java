package com.example.software.Entity;

public class Guides {
    private int guideUsersID;
    private String firstName;
    private String lastName;
    private String email;
    private int phoneNumber;
    private String guide_Picture;

    public Guides() {
    }

    public int getGuideUsersID() {
        return guideUsersID;
    }

    public void setGuideUsersID(int guideUsersID) {
        this.guideUsersID = guideUsersID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGuide_Picture() {
        return guide_Picture;
    }

    public void setGuide_Picture(String guide_Picture) {
        this.guide_Picture = guide_Picture;
    }
}
