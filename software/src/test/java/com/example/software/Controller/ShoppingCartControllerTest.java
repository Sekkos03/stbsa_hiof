package com.example.software.Controller;

import com.example.software.Entity.ShoppingCart;
import com.example.software.controller.ShoppingCartController;
import com.example.software.service.ShoppingCartService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ShoppingCartController.class)
public class ShoppingCartControllerTest {

    @InjectMocks
    private ShoppingCartController shoppingCartController;

    @MockBean
    private ShoppingCartService shoppingCartService;

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(shoppingCartController).build();
    }

    @Test
    public void testGetShoppingCartForOnePerson() throws Exception {
        int touristID = 1;
        ShoppingCart cartItem = new ShoppingCart();
        cartItem.setTouristID(touristID);
        cartItem.setTourID(100);
        cartItem.setTime("2025-06-30 13:00:00");
        cartItem.setAmountOfPeople(4);

        List<ShoppingCart> cartItems = Collections.singletonList(cartItem);
        when(shoppingCartService.getEntireShoppingCartForOnePerson(touristID)).thenReturn(cartItems);

        mockMvc.perform(get("/getShoppingCartForOnePerson/{id}", touristID))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].touristID").value(touristID))
                .andExpect(jsonPath("$[0].tourID").value(100))
                .andExpect(jsonPath("$[0].time").value("2025-06-30 13:00:00"))
                .andExpect(jsonPath("$[0].amountOfPeople").value(4));
    }

    @Test
    public void testAddTourToShoppingCartForOnePerson() throws Exception {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setTouristID(1);
        shoppingCart.setTourID(100);
        shoppingCart.setTime("2025-06-30 13:00:00");
        shoppingCart.setAmountOfPeople(4);

        mockMvc.perform(post("/addTourToShoppingCartForOnePerson")
                        .content(objectMapper.writeValueAsString(shoppingCart))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(shoppingCartService, times(1)).addTourToShoppingCartForOnePerson(1, 100, "2025-06-30 13:00:00", 4);
    }

    @Test
    public void testDeleteEntireShoppingCartForOnePerson() throws Exception {
        int touristID = 1;

        mockMvc.perform(delete("/deleteEntireShoppingCartForOnePerson/{id}", touristID))
                .andExpect(status().isOk());

        verify(shoppingCartService, times(1)).deleteEntireShoppingCartForOnePerson(touristID);
    }
}

