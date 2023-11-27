package com.example.software.controller;

import com.example.software.Entity.BookedTour;
import com.example.software.service.BookedTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BookedTourController {

    @Autowired
    BookedTourService bookedTourService;

    @PostMapping("/addItemToBookedTour")
    public void addItemToBookedTour(@RequestBody BookedTour bookedTour){
        bookedTourService.addItemToBookedTour(bookedTour.getGuideuserID(), bookedTour.getTouristID(), bookedTour.getTime(), bookedTour.getAmountOfPeople(), bookedTour.getTourID());
    }

    @GetMapping("/getAllBookedTourForOneGuide/{guideUserID}")
    public List<BookedTour> getAllBookedTourForOneGuide(@PathVariable int guideUserID){
        return bookedTourService.GetAllBookedTourForOneGuide(guideUserID);
    }

    @DeleteMapping("/deleteOneItemFromBookedTour/{bookedTourID}")
    public void deleteItemFromBookedTour(@PathVariable int bookedTourID){
        bookedTourService.deleteItemFromBookedTour(bookedTourID);
    }

    @GetMapping("/getAllBookdeTours")
    public List<BookedTour> getAllBookdeTours(){
        return bookedTourService.getAllBookedTours();
    }
}
