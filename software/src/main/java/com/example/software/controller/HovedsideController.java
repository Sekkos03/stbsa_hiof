package com.example.software.controller;

import com.example.software.Hovedside;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HovedsideController {

    @GetMapping("/hovedside")
    public Hovedside hovedside() {
     return new Hovedside();
    }
}