package com.example.software.controller;

import com.example.software.Hovedside;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HovedsideController {

    @Autowired
    JdbcTemplate jdbcTemplate = new JdbcTemplate();



    @GetMapping("/hovedside")
    public String hovedside() {
        return null;
    }
}