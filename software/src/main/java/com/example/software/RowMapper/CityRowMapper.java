package com.example.software.RowMapper;

import com.example.software.Entity.City;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CityRowMapper implements RowMapper<City> {
    @Override
    public City mapRow(ResultSet rs, int rowNum) throws SQLException {
        City obj = new City();
        obj.setCityID(rs.getInt("cityID"));
        obj.setCity(rs.getString("city"));
        obj.setCity_countryID(rs.getInt("city_countryID"));
        obj.setCity_picture(rs.getString("City_picture"));
        return obj;
    }
}
