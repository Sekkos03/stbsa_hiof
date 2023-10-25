package com.example.software.controller;

import com.example.software.Country;
import com.example.software.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/allCountries")
    public List<Country> getAllCountries() {
        return countryService.getAllCountry();
    }
}
