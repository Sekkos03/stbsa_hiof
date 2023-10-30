package com.example.software.Service;

import com.example.software.Entity.Tour;
import com.example.software.RowMapper.TourRowMapper;
import com.example.software.service.TourService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TourServiceTest {

    @InjectMocks
    private TourService tourService;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllTours() {
        // Given
        Tour tour = createSampleTour();
        List<Tour> expectedTours = Collections.singletonList(tour);

        when(jdbcTemplate.query(eq("select * from tour"), any(TourRowMapper.class))).thenReturn(expectedTours);

        // When
        List<Tour> actualTours = tourService.getAllTours();

        // Then
        verify(jdbcTemplate, times(1)).query(eq("select * from tour"), any(TourRowMapper.class));
        assertEquals(expectedTours, actualTours);
    }

    @Test
    public void testGetOneTourByID() {

        int givenTourId = 1;
        Tour expectedTour = createSampleTour();

        when(jdbcTemplate.queryForObject(
                eq("select * from tour WHERE tourID = ?"),
                any(TourRowMapper.class),
                eq(givenTourId)))
                .thenReturn(expectedTour);

        Tour actualTour = tourService.getOneTourByID(givenTourId);

        verify(jdbcTemplate, times(1)).queryForObject(
                eq("select * from tour WHERE tourID = ?"),
                any(TourRowMapper.class),
                eq(givenTourId));
        assertEquals(expectedTour, actualTour);
    }

    private Tour createSampleTour() {
        Tour tour = new Tour();
        tour.setTourID(1);
        tour.setGuideUserID(10);
        tour.setCityID(5);
        tour.setDescription("Sample Description");
        tour.setPrice(100);
        tour.setMaxPeople(10);
        tour.setTour_picture("sample.jpg");
        tour.setTitle("Sample Tour");
        return tour;
    }
}
