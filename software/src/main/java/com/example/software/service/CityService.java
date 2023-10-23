package com.example.software.service;

import com.example.software.City;
import com.example.software.RowMapper.CityRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<City> getAllCitys() {
        return jdbcTemplate.query("select * from city ", new CityRowMapper());
    }

}
