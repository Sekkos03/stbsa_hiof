package com.example.software.Service;

import com.example.software.Entity.BookedTour;
import com.example.software.RowMapper.BookedTourRowMapper;
import com.example.software.service.BookedTourService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BookedTourServiceTest {

    @InjectMocks
    private BookedTourService bookedTourService;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddItemToBookedTour() {
        // Given
        int guideUserID = 1;
        int touristID = 2;
        String time = "10:00:00";
        int amountOfPeople = 4;
        int tourID = 3;

        // When
        bookedTourService.addItemToBookedTour(guideUserID, touristID, time, amountOfPeople, tourID);

        // Then
        verify(jdbcTemplate).update("insert into bookedTour (guideUserID, touristID, time, amountOfPeople, tourID) values (?, ?, ?, ?, ?)", guideUserID, touristID, time, amountOfPeople, tourID);
    }

    @Test
    public void testGetAllBookedTourForOneGuide() {
        int guideUserID = 1;
        List<BookedTour> expectedTours = Arrays.asList(
                new BookedTour(1, 2, 2, "10:00:00", 4, 6),
                new BookedTour(4, 5, 1, "15:00:00", 2, 10)
        );

        when(jdbcTemplate.query(
                eq("select * from bookedTour where guideUserID = ? "),
                any(BookedTourRowMapper.class),
                eq(guideUserID))
        ).thenReturn(expectedTours);

        List<BookedTour> result = bookedTourService.GetAllBookedTourForOneGuide(guideUserID);

        assertEquals(expectedTours, result);
        verify(jdbcTemplate).query(
                eq("select * from bookedTour where guideUserID = ? "),
                any(BookedTourRowMapper.class),
                eq(guideUserID)
        );
    }

    @Test
    public void testDeleteItemFromBookedTour() {
        int bookedTourID = 123;

        bookedTourService.deleteItemFromBookedTour(bookedTourID);

        verify(jdbcTemplate).update("delete from bookedTour where bookedTourID = ?", bookedTourID);
    }

    @Test
    public void testGetAllBookedTourss() {
        // Setting up test data
        List<BookedTour> expectedTours = Arrays.asList(
                new BookedTour(1, 2, 2, "10:00:00", 4, 6),
                new BookedTour(4, 5, 1, "15:00:00", 2, 10)
        );

        // Mocking the jdbcTemplate behavior
        when(jdbcTemplate.query(
                eq("select * from bookedTour"),
                any(BookedTourRowMapper.class))
        ).thenReturn(expectedTours);

        // Method under test
        List<BookedTour> actualTours = bookedTourService.getAllBookedTours();

        // Asserting the results
        assertEquals(expectedTours, actualTours);

        // Verifying the jdbcTemplate behavior
        verify(jdbcTemplate).query(
                eq("select * from bookedTour"),
                any(BookedTourRowMapper.class));
    }


}
