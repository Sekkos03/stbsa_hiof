package com.example.software.controller;

import com.example.software.City;
import com.example.software.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/allCitys")
    public List<City> getAllCitys() {
        return cityService.getAllCitys();
    }

}
