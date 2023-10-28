package com.example.software.controller;

import com.example.software.Entity.BookedTour;
import com.example.software.service.BookedTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BookedTourController {

    @Autowired
    BookedTourService bookedTourService;

    @PostMapping("/addItemToBookedTour")
    public void addItemToBookedTour(@RequestBody BookedTour bookedTour){
        bookedTourService.addItemToBookedTour(bookedTour.getGuideuserID(), bookedTour.getTouristID(), bookedTour.getTime(), bookedTour.getAmountOfPeople());
    }
}
