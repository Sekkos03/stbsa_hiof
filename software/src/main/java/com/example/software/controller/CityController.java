package com.example.software.controller;

import com.example.software.service.City;
import com.example.software.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("/allCitys")
    public List<String> getAllCitys() {
        return cityService.getAllCitys();
    }

}
