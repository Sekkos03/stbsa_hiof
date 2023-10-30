package com.example.software.Service;

import com.example.software.Entity.ShoppingCart;
import com.example.software.RowMapper.ShoppingCartRowMapper;
import com.example.software.service.ShoppingCartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public class ShoppingCartServiceTest {

    @InjectMocks
    private ShoppingCartService shoppingCartService;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setUp() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetEntireShoppingCartForOnePerson() {
        // Given
        int touristID = 1;
        ShoppingCart cartItem = new ShoppingCart();
        cartItem.setTouristID(touristID);
        cartItem.setTourID(1);
        cartItem.setTime("2025-06-30 13:00:00");
        cartItem.setAmountOfPeople(4);

        List<ShoppingCart> expectedCart = Collections.singletonList(cartItem);

        when(jdbcTemplate.query(
                eq("select * from Shoppingcart where touristID = ?"),
                any(ShoppingCartRowMapper.class),
                eq(touristID)
        )).thenReturn(expectedCart);

        // When
        List<ShoppingCart> actualCart = shoppingCartService.getEntireShoppingCartForOnePerson(touristID);

        // Then
        verify(jdbcTemplate, times(1)).query(
                eq("select * from Shoppingcart where touristID = ?"),
                any(ShoppingCartRowMapper.class),
                eq(touristID)
        );
        assert expectedCart.equals(actualCart);
    }

    @Test
    public void testAddTourToShoppingCartForOnePerson() {
        // Given
        int touristID = 1;
        int tourID = 1;
        String time = "2025-06-30 13:00:00";
        int amountOfPeople = 4;

        // When
        shoppingCartService.addTourToShoppingCartForOnePerson(touristID, tourID, time, amountOfPeople);

        // Then
        verify(jdbcTemplate, times(1)).update(
                eq("insert into Shoppingcart values (?, ?, ?, ?)"),
                eq(touristID), eq(tourID), eq(time), eq(amountOfPeople)
        );
    }

    @Test
    public void testDeleteEntireShoppingCartForOnePerson() {
        // Given
        int touristID = 1;

        // When
        shoppingCartService.deleteEntireShoppingCartForOnePerson(touristID);

        // Then
        verify(jdbcTemplate, times(1)).update(
                eq("DELETE FROM Shoppingcart WHERE touristID = ?"),
                eq(touristID)
        );
    }
}
