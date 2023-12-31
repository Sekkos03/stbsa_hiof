package com.example.software.Controller;

import com.example.software.Entity.BookedTour;
import com.example.software.controller.BookedTourController;
import com.example.software.service.BookedTourService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BookedTourControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private BookedTourController bookedTourController;

    @Mock
    private BookedTourService bookedTourService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(bookedTourController).build();
    }

    @Test
    public void testAddItemToBookedTour() throws Exception {
        BookedTour bookedTour = new BookedTour();
        bookedTour.setGuideuserID(1);
        bookedTour.setTouristID(2);
        bookedTour.setTime("10:00:00");
        bookedTour.setAmountOfPeople(4);
        bookedTour.setTourID(5);

        ObjectMapper objectMapper = new ObjectMapper();
        String bookedTourJson = objectMapper.writeValueAsString(bookedTour);

        mockMvc.perform(post("/addItemToBookedTour")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookedTourJson))
                .andExpect(status().isOk());

        verify(bookedTourService).addItemToBookedTour(bookedTour.getGuideuserID(), bookedTour.getTouristID(), bookedTour.getTime(), bookedTour.getAmountOfPeople(), bookedTour.getTourID());
    }

    @Test
    public void testAddItemToBookedTourWithNegativeAmountOfPeople() throws Exception {
        BookedTour bookedTour = new BookedTour();
        bookedTour.setGuideuserID(1);
        bookedTour.setTouristID(2);
        bookedTour.setTime("10:00:00");
        bookedTour.setAmountOfPeople(-4);
        bookedTour.setTourID(5);

        mockMvc.perform(post("/addItemToBookedTour")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookedTour.toString()))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetAllBookedTourForOneGuide() throws Exception {
        int guideUserID = 1; // Example guide user ID
        List<BookedTour> expectedTours = Arrays.asList(
                new BookedTour(1, 1, 3, "10:00:00", 4, 5),
                new BookedTour(3, 1, 2, "15:00:00", 19, 2)
        );

        when(bookedTourService.GetAllBookedTourForOneGuide(guideUserID)).thenReturn(expectedTours);

        mockMvc.perform(get("/getAllBookedTourForOneGuide/{guideUserID}", guideUserID))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(expectedTours.size())))
                .andExpect(jsonPath("$[0].bookedTourID").value(expectedTours.get(0).getBookedTourID()))
                .andExpect(jsonPath("$[0].guideuserID").value(expectedTours.get(0).getGuideuserID()))
                .andExpect(jsonPath("$[0].touristID").value(expectedTours.get(0).getTouristID()))
                .andExpect(jsonPath("$[0].time").value(expectedTours.get(0).getTime()))
                .andExpect(jsonPath("$[0].amountOfPeople").value(expectedTours.get(0).getAmountOfPeople()))
                .andExpect(jsonPath("$[0].tourID").value(expectedTours.get(0).getTourID()))
        ;
    }

    @Test
    public void testDeleteItemFromBookedTour() throws Exception {
        int bookedTourID = 123; // Example booked tour ID

        mockMvc.perform(delete("/deleteOneItemFromBookedTour/{bookedTourID}", bookedTourID))
                .andExpect(status().isOk());

        verify(bookedTourService).deleteItemFromBookedTour(bookedTourID);
    }

    @Test
    public void testGetAllBookedTours() throws Exception {
        List<BookedTour> expectedTours = Arrays.asList(
                new BookedTour(1, 1, 3, "10:00:00", 4, 5),
                new BookedTour(3, 1, 2, "15:00:00", 19, 2)
        );

        when(bookedTourService.getAllBookedTours()).thenReturn(expectedTours);


        mockMvc.perform(get("/getAllBookedTours"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(expectedTours.size())))
        ;
    }

}
