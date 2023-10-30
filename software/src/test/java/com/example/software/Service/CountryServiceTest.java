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
        // Initialize mocks
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCountry() {
        // Given
        Country country = new Country();
        country.setCountryID(1);
        country.setCountry("USA");
        country.setCountry_picture("usa_picture_url.jpg"); // Sample picture URL

        List<Country> expectedCountries = Collections.singletonList(country);

        when(jdbcTemplate.query(eq("select * from country "), any(CountryRowMapper.class)))
                .thenReturn(expectedCountries);


        List<Country> actualCountries = countryService.getAllCountry();


        verify(jdbcTemplate).query(eq("select * from country "), any(CountryRowMapper.class));
        assertEquals(expectedCountries, actualCountries);
    }
}

