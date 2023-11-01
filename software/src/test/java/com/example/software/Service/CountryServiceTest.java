package com.example.software.Service;

import com.example.software.Entity.Country;
import com.example.software.RowMapper.CountryRowMapper;
import com.example.software.service.CountryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountryServiceTest {

    @InjectMocks
    private CountryService countryService;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setUp() {

        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCountries() {

        Country country1 = new Country();
        country1.setCountryID(1);
        country1.setCountry("USA");
        country1.setCountry_picture("usa_picture_url.jpg");

        Country country2 = new Country();
        country2.setCountryID(2);
        country2.setCountry("Canada");
        country2.setCountry_picture("Canada_picture_url.jpg");

        List<Country> expectedCountries = Arrays.asList(country1, country2);

        when(jdbcTemplate.query(eq("select * from country "), any(CountryRowMapper.class)))
                .thenReturn(expectedCountries);

        List<Country> actualCountries = countryService.getAllCountries();


        verify(jdbcTemplate).query(eq("select * from country "), any(CountryRowMapper.class));
        assertEquals(expectedCountries, actualCountries);
    }
}

