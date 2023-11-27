package com.example.software.Controller;

import com.example.software.Entity.Guides;
import com.example.software.controller.GuidesController;
import com.example.software.controller.TouristController;
import com.example.software.service.GuidesService;
import com.example.software.service.TouristService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class GuidesControllerTest {

    @InjectMocks
    private GuidesController guidesController;

    @Mock
    private GuidesService guidesService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(guidesController).build();
    }

    @Test
    public void testGetGuideByID() throws Exception {
        int guideID = 1;
        Guides expectedGuide = new Guides(1,"fg", "few", "kenaa@example.com", 4654320, "fg.jpg");

        // Mocking the GuidesService
        when(guidesService.getGuideByID(guideID)).thenReturn(expectedGuide);

        // Performing the GET request and validating the response
        mockMvc.perform(get("/getGuideByID/{guideID}", guideID))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.guideUsersID").value(expectedGuide.getGuideUsersID()))
                .andExpect(jsonPath("$.firstName").value(expectedGuide.getFirstName()))
                .andExpect(jsonPath("$.lastName").value(expectedGuide.getLastName()))
                .andExpect(jsonPath("$.email").value(expectedGuide.getEmail()))
                .andExpect(jsonPath("$.phoneNumber").value(expectedGuide.getPhoneNumber()))
                .andExpect(jsonPath("$.guide_Picture").value(expectedGuide.getGuide_Picture()))
        ;
    }

}
