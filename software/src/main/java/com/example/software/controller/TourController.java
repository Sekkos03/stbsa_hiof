package com.example.software.controller;

import com.example.software.Tour;
import com.example.software.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TourController {

    @Autowired
    private TourService tourService;

    @GetMapping("/allTours")
    public List<Tour> getAllCitys() {
        return tourService.getAllTours();
    }

    @GetMapping("/OneTour/{id}")
    public Tour getOneTourById(@PathVariable int id) {
        return tourService.getOneTourByID(id);
    }
}
