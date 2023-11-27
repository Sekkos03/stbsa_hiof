package com.example.software.service;

import com.example.software.Entity.BookedTour;
import com.example.software.RowMapper.BookedTourRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookedTourService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addItemToBookedTour(int guideUserID, int touristID, String time, int amountOdPeople, int tourID) {
        jdbcTemplate.update("insert into bookedTour (guideUserID, touristID, time, amountOfPeople, tourID) values (?, ?, ?, ?, ?)", guideUserID, touristID, time, amountOdPeople, tourID);
    }

    public List<BookedTour> GetAllBookedTourForOneGuide(int guideUserID) {
        return jdbcTemplate.query("select * from bookedTour where guideUserID = ? ",new BookedTourRowMapper(), guideUserID);
    }

    public void deleteItemFromBookedTour(int bookedTourID) {
        jdbcTemplate.update("delete from bookedTour where bookedTourID = ?", bookedTourID);
    }

    public List<BookedTour> getAllBookdeTours() {
        return jdbcTemplate.query("select * from bookedTour", new BookedTourRowMapper());
    }
}
