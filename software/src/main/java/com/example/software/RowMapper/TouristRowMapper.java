package com.example.software.RowMapper;

import com.example.software.Entity.Tourist;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TouristRowMapper implements RowMapper<Tourist> {

    @Override
    public Tourist mapRow(ResultSet rs, int rowNum) throws SQLException {

        Tourist obj = new Tourist();

        obj.setTouristID(rs.getInt("touristID"));
        obj.setFirstName(rs.getString("FirstName"));
        obj.setLastName(rs.getString("lastName"));
        obj.setEmail(rs.getString("email"));
        obj.setPhoneNumber(rs.getInt("phoneNumber"));

        return obj;
    }
}
