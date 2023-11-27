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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.server.ResponseStatusException;


import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


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
    public void testGetAllBookedTourForOneGuide_Success() throws Exception {
        int guideUserID = 1;
        List<BookedTour> mockedList = Arrays.asList(new BookedTour(1, 1, 1, "10:00:00",3 ,1),
                new BookedTour(3, 1, 3, "15:00:00",1 ,1));

        given(bookedTourService.GetAllBookedTourForOneGuide(guideUserID)).willReturn(mockedList);

        mockMvc.perform(get("/getAllBookedTourForOneGuide/{guideUserID}", guideUserID))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(mockedList.size())));
    }

    @Test
    public void testGetAllBookedTourForOneGuide_Failure() throws Exception {
        int guideUserID = 2;
        given(bookedTourService.GetAllBookedTourForOneGuide(guideUserID))
                .willThrow(new ResponseStatusException(HttpStatus.NOT_FOUND, "Guide not found"));

        mockMvc.perform(get("/getAllBookedTourForOneGuide/{guideUserID}", guideUserID))
                .andExpect(status().isNotFound());
    }

}
