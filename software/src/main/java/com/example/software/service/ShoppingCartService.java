package com.example.software.service;

import com.example.software.Entity.ShoppingCart;
import com.example.software.RowMapper.ShoppingCartRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ShoppingCart> getEntireShoppingCartForOnePerson(int id){
        return jdbcTemplate.query("select * from Shoppingcart where touristID = ?", new ShoppingCartRowMapper(), id);
    }

    public void addTourToShoppingCartForOnePerson(int touristID, int tourID, String time, int amountOdPeople){
        jdbcTemplate.update("insert into Shoppingcart values (?, ?, ?, ?)", touristID, tourID, time, amountOdPeople );
    }

    public void deleteEntireShoppingCartForOnePerson(int touristID) {
        jdbcTemplate.update("DELETE FROM Shoppingcart WHERE touristID = ?", touristID);
    }


    public void deleteOneShoppingCartItemForOnePerson(int userID, int tourID) {
        jdbcTemplate.update("delete from Shoppingcart where touristID = ? and tourID = ?", userID, tourID);
    }
}
