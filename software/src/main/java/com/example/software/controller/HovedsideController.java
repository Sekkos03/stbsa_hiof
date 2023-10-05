package com.example.software.controller;

import com.example.software.Hovedside;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HovedsideController {

    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public int addEmplyee(int id) {
        return jdbcTemplate.update(
                "INSERT INTO EMPLOYEE VALUES (?)", id);
    }

    public int removeEmplyee(int id) {
        return jdbcTemplate.update(
                "DELETE FROM EMPLOYEE WHERE ID =?", id);
    }

    public int allEmpoyee() {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM EMPLOYEE", Integer.class);
    }

    @GetMapping("/hovedside")
    public Hovedside hovedside() {
        allEmpoyee();
     return new Hovedside();
    }
}