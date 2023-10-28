package com.example.software.RowMapper;

import com.example.software.Entity.ShoppingCart;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShoppingCartRowMapper implements RowMapper<ShoppingCart> {

    @Override
    public ShoppingCart mapRow(ResultSet rs, int rowNum) throws SQLException {

        ShoppingCart obj = new ShoppingCart();

        obj.setTouristID(rs.getInt("touristID"));
        obj.setTourID(rs.getInt("tourID"));
        obj.setTime(rs.getString("Time"));
        obj.setAmountOfPeople(rs.getInt("amountOfPeople"));

        return obj;
    }
}
