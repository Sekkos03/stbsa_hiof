package com.example.software.service;

import com.example.software.Entity.Country;
import com.example.software.RowMapper.CountryRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Country> getAllCountries() {
        return jdbcTemplate.query("select * from country ", new CountryRowMapper());
    }

}
