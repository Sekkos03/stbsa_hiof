package com.example.software;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HovedsideController {

    @GetMapping("/hovedside")
    public Hovedside hovedside(@RequestParam(value = "i", defaultValue = "0") int i) {
     return new Hovedside(i);
    }
}
