package com.example.software.service;

import com.example.software.Entity.Guides;
import com.example.software.RowMapper.GuidesRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class GuidesService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Guides getGuideByID(int guideID) {
        return jdbcTemplate.queryForObject("select * from guidesUsers where GuideUsersID = ?", new GuidesRowMapper(), guideID);
    }


}
