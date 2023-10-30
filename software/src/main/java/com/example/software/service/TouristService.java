package com.example.software.service;

import com.example.software.RowMapper.TouristRowMapper;
import com.example.software.Entity.Tourist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Tourist> getAllTourists() {
        return jdbcTemplate.query("select * from tourist", new TouristRowMapper());
    }

    public Tourist getOneTouristByID(int touristID) {
        return jdbcTemplate.queryForObject("select * from tourists where touristID = ?", new TouristRowMapper(), touristID);
    }
}
