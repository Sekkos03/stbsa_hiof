package com.example.software.service;

import com.example.software.RowMapper.TourRowMapper;
import com.example.software.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Tour> getAllTours() {
        return jdbcTemplate.query("select * from tour", new TourRowMapper());
    }

}
