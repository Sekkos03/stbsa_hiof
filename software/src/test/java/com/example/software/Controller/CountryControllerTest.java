package com.example.software.Controller;

import com.example.software.Entity.Country;
import com.example.software.controller.CountryController;
import com.example.software.service.CountryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CountryController.class)
public class CountryControllerTest {

    @InjectMocks
    private CountryController countryController;

    @MockBean
    private CountryService countryService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(countryController).build();
    }

    @Test
    public void testGetAllCountries() throws Exception {

        Country country1 = new Country();
        country1.setCountryID(1);
        country1.setCountry("USA");
        country1.setCountry_picture("usa_picture_url.jpg");

        Country country2 = new Country();
        country2.setCountryID(2);
        country2.setCountry("Canada");
        country2.setCountry_picture("canada_picture_url.jpg");

        List<Country> countries = Arrays.asList(country1, country2);
        when(countryService.getAllCountries()).thenReturn(countries);


        mockMvc.perform(get("/allCountries")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].country").value("USA"))
                .andExpect(jsonPath("$[1].country").value("Canada"));
    }
}
