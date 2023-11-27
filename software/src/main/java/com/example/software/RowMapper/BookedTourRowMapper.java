package com.example.software.RowMapper;

import com.example.software.Entity.BookedTour;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookedTourRowMapper implements RowMapper<BookedTour> {


    @Override
    public BookedTour mapRow(ResultSet rs, int rowNum) throws SQLException {

        BookedTour obj = new BookedTour();

        obj.setBookedTourID(rs.getInt("bookedTourID"));
        obj.setGuideuserID(rs.getInt("touristID"));
        obj.setTouristID(rs.getInt("touristID"));
        obj.setTime(rs.getString("time"));
        obj.setAmountOfPeople(rs.getInt("amountOfPeople"));
        obj.setTourID(rs.getInt("tourID"));

        return obj;
    }
}
