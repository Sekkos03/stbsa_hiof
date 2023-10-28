package com.example.software.RowMapper;

import com.example.software.Entity.Country;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryRowMapper implements RowMapper<Country> {

    @Override
    public Country mapRow(ResultSet rs, int rowNum) throws SQLException {

        Country obj = new Country();

        obj.setCountryID(rs.getInt("countryId"));
        obj.setCountry(rs.getString("country"));
        obj.setCountry_picture(rs.getString("country_picture"));
        return obj;
    }
}
