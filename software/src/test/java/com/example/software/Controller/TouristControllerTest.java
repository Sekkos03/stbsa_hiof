package com.example.software.Controller;

import com.example.software.Entity.Tourist;
import com.example.software.controller.TouristController;
import com.example.software.service.TouristService;
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

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

public class TouristControllerTest {

    @InjectMocks
    private TouristController touristController;

    @Mock
    private TouristService touristService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(touristController).build();
    }

    @Test
    public void testGetAllTourists() throws Exception {

        Tourist tourist1 = new Tourist();
        tourist1.setTouristID(1);
        tourist1.setFirstName("John");
        tourist1.setLastName("Doe");
        tourist1.setEmail("john.doe@example.com");
        tourist1.setPhoneNumber(4654320);

        Tourist tourist2 = new Tourist();
        tourist2.setTouristID(2);
        tourist2.setFirstName("Jane");
        tourist2.setLastName("Smith");
        tourist2.setEmail("jane.smith@example.com");
        tourist2.setPhoneNumber(73355074);

        List<Tourist> tourists = Arrays.asList(tourist1, tourist2);

        when(touristService.getAllTourists()).thenReturn(tourists);

        mockMvc.perform(get("/allTourists")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

        verify(touristService).getAllTourists();
    }

    @Test
    public void testGetOneTouristById() throws Exception {

        Tourist tourist = new Tourist();
        tourist.setTouristID(3);
        tourist.setFirstName("John");
        tourist.setLastName("Doe");
        tourist.setEmail("john.doe@example.com");
        tourist.setPhoneNumber(4654320);

        int touristId = 3;
        when(touristService.getOneTouristByID(touristId)).thenReturn(tourist);

        mockMvc.perform(get("/tourist/{id}", touristId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

        verify(touristService).getOneTouristByID(touristId);
    }

    @Test
    public void testGetOneTouristByIdNotFound() throws Exception {
        int nonExistentTouristId = 999;

        mockMvc.perform(get("/tourist/{id}", nonExistentTouristId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(touristService).getOneTouristByID(nonExistentTouristId);
    }
}
