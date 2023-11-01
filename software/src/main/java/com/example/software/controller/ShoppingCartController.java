package com.example.software.controller;

import com.example.software.Entity.ShoppingCart;
import com.example.software.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;

    @GetMapping("/getShoppingCartForOnePerson/{id}")
    public List<ShoppingCart> getShoppingCartForOnePerson(@PathVariable int id){
        return shoppingCartService.getEntireShoppingCartForOnePerson(id);
    }

    @PostMapping("/addTourToShoppingCartForOnePerson")
    public void addTourToShoppingCartForOnePerson(@RequestBody ShoppingCart shoppingCart){
        shoppingCartService.addTourToShoppingCartForOnePerson(shoppingCart.getTouristID(), shoppingCart.getTourID(), shoppingCart.getTime(), shoppingCart.getAmountOfPeople());
    }

    @DeleteMapping("/deleteEntireShoppingCartForOnePerson/{id}")
    public void deleteEntireShoppingCartForOnePerson(@PathVariable int id){
        shoppingCartService.deleteEntireShoppingCartForOnePerson(id);
    }

    @DeleteMapping("/deleteOneShoppingCartItemForOnePerson/user/{userID}/tour/{tourID}")
    public void deleteOneShoppingCartItemForOnePerson(@PathVariable int userID, @PathVariable int tourID){
        shoppingCartService.deleteOneShoppingCartItemForOnePerson(userID, tourID);
    }
}