package com.example.software.Controller;

import com.example.software.Entity.City;
import com.example.software.service.CityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CityService cityService;

    @BeforeEach
    public void setUp() {

        City city1 = new City();
        city1.setCityID(1);
        city1.setCity("New York");
        city1.setCity_countryID(101);
        city1.setCity_picture("new_york_picture.jpg");

        City city2 = new City();
        city2.setCityID(2);
        city2.setCity("Los Angeles");
        city2.setCity_countryID(102);
        city2.setCity_picture("la_picture.jpg");

        when(cityService.getAllCitys()).thenReturn(Arrays.asList(city1, city2));
    }

    @Test
    public void testGetAllCitys() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/allCitys")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].city").value("New York"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].city").value("Los Angeles"));
    }
}
