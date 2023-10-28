package com.example.software.RowMapper;

import com.example.software.Entity.Tour;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TourRowMapper implements RowMapper<Tour> {

    @Override
    public Tour mapRow(ResultSet rs, int rowNum) throws SQLException {

        Tour obj = new Tour();

        obj.setTourID(rs.getInt("tourID"));
        obj.setGuideUserID(rs.getInt("guideUserID"));
        obj.setCityID(rs.getInt("cityID"));
        obj.setDescription(rs.getString("description"));
        obj.setPrice(rs.getInt("price"));
        obj.setMaxPeople(rs.getInt("maxPeople"));
        obj.setTour_picture(rs.getString("tour_picture"));
        obj.setTitle(rs.getString("title"));
        return obj;
    }
}