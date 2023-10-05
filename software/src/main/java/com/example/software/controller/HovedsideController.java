package com.example.software.controller;

import com.example.software.Hovedside;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
public class HovedsideController {

    @Autowired
    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public int addEmplyee(int id, String firstName) {
        return jdbcTemplate.update(
                "INSERT INTO EMPLOYEE VALUES (?, ?)", id, firstName);
    }

    public int removeEmplyee(int id) {
        return jdbcTemplate.update(
                "DELETE FROM EMPLOYEE WHERE ID =?", id);
    }

    public String allEmpoyee() {
        return jdbcTemplate.queryForObject("SELECT * FROM EMPLOYEE where ID = 2", (rs, rowNum) -> rs.getInt("ID") + " " + rs.getString("FirstName"));
    }
    @GetMapping("/hovedside")
    public Hovedside hovedside() {
        allEmpoyee();
        return new Hovedside();
    }
}