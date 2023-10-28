package com.example.software.controller;

import com.example.software.Entity.Tourist;
import com.example.software.service.ToursistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TouristController {

    @Autowired
    private ToursistService touristService;

    @GetMapping("/allTourists")
    public List<Tourist> getAllTourists() {
        return touristService.getAllTourists();
    }

    @GetMapping("/tourist/{id}")
    public Tourist getOneTouristById(@PathVariable int id) {
        return touristService.getOneTouristByID(id);
    }

}
