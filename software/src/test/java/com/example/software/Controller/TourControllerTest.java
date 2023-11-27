package com.example.software.Controller;

import com.example.software.Entity.Tour;
import com.example.software.service.TourService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TourControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TourService tourService;

    @BeforeEach
    public void setup() {
        Tour tour1 = new Tour();
        tour1.setTourID(1);
        tour1.setGuideUserID(1);
        tour1.setCityID(10);
        tour1.setDescription("A comprehensive tour around the historical landmarks of the city.");
        tour1.setPrice(100);
        tour1.setMaxPeople(20);
        tour1.setTour_picture("https://example.com/tour1.jpg");
        tour1.setTitle("Historical City Landmarks");

        Tour tour2 = new Tour();
        tour2.setTourID(2);
        tour2.setGuideUserID(1002);
        tour2.setCityID(11);
        tour2.setDescription("Explore the natural beauty and landscapes of the region.");
        tour2.setPrice(150);
        tour2.setMaxPeople(15);
        tour2.setTour_picture("https://example.com/tour2.jpg");
        tour2.setTitle("Natural Landscapes Exploration");

        when(tourService.getAllTours()).thenReturn(Arrays.asList(tour1, tour2));
        when(tourService.getOneTourByID(1)).thenReturn(tour1);
    }

    @Test
    public void testGetAllTours() throws Exception {
        mockMvc.perform(get("/allTours"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].tourID", is(1)))
                .andExpect(jsonPath("$[1].tourID", is(2)));
    }

    @Test
    public void testGetOneTourById() throws Exception {
        mockMvc.perform(get("/OneTour/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tourID", is(1)));
    }

    @Test
    public void testGetOneTourByIdNonExistent() throws Exception {
        int nonExistentTourId = 999;
        when(tourService.getOneTourByID(nonExistentTourId)).thenReturn(null);

        mockMvc.perform(get("/OneTour/{id}", nonExistentTourId))
                .andExpect(status().isNotFound());

        verify(tourService).getOneTourByID(nonExistentTourId);
    }

}

