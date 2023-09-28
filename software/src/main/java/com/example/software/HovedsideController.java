package com.example.software;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HovedsideController {

    @GetMapping("/hovedside")
    public Hovedside hovedside() {
     return null;
    }
}
