package com.example.software.Service;

import com.example.software.Entity.City;
import com.example.software.RowMapper.CityRowMapper;
import com.example.software.service.CityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CityServiceTest {

    @InjectMocks
    private CityService cityService;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCitys() {

        City city = new City();
        city.setCityID(1);
        city.setCity("New York");
        city.setCity_countryID(3);
        city.setCity_picture("new_york_picture_url.jpg");

        List<City> expectedCities = Collections.singletonList(city);

        when(jdbcTemplate.query(eq("select * from city "), any(CityRowMapper.class)))
                .thenReturn(expectedCities);


        List<City> actualCities = cityService.getAllCitys();


        verify(jdbcTemplate).query(eq("select * from city "), any(CityRowMapper.class));
        assertEquals(expectedCities, actualCities);
    }
}

