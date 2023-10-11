package com.example.software.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CityService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<String> getAllCitys() {
        return jdbcTemplate.query("select city from city ", (rs, rowNum) -> rs.getString("city"));
    }

}
