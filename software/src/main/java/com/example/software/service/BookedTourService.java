package com.example.software.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookedTourService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addItemToBookedTour(int guideUserID, int touristID, String time, int amountOdPeople){
        jdbcTemplate.update("insert into bookedTour (guideUserID, touristID, time, amountOfPeople) values (?, ?, ?, ?)", guideUserID, touristID, time, amountOdPeople );
    }
}
