package com.example.software.Service;

import com.example.software.service.BookedTourService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.Mockito.verify;

public class BookedTourServiceTest {

    @InjectMocks
    private BookedTourService bookedTourService;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setUp() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddItemToBookedTour() {
        // Given
        int guideUserID = 1;
        int touristID = 2;
        String time = "10:00:00";
        int amountOfPeople = 4;

        // When
        bookedTourService.addItemToBookedTour(guideUserID, touristID, time, amountOfPeople);

        // Then
        verify(jdbcTemplate).update("insert into bookedTour (guideUserID, touristID, time, amountOfPeople) values (?, ?, ?, ?)", guideUserID, touristID, time, amountOfPeople);
    }
}
