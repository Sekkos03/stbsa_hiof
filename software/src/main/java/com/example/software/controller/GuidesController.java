package com.example.software.controller;

import com.example.software.Entity.Guides;
import com.example.software.service.GuidesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class GuidesController {

    @Autowired
    GuidesService guidesService;

    @GetMapping("/getGuideByID/{guideID}")
    public Guides getGuideByID(@PathVariable int guideID){
        return guidesService.getGuideByID(guideID);
    }

}
