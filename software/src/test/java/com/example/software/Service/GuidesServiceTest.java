package com.example.software.Service;

import com.example.software.Entity.Guides;
import com.example.software.RowMapper.GuidesRowMapper;
import com.example.software.service.BookedTourService;
import com.example.software.service.GuidesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GuidesServiceTest {
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @InjectMocks
    private GuidesService guidesService;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testGetGuideByID() {
        int guideID = 1;
        Guides expectedGuide = new Guides(/* initialize with valid data */);

        // Mocking the jdbcTemplate behavior
        when(jdbcTemplate.queryForObject(
                eq("select * from guidesUsers where GuideUsersID = ?"),
                any(GuidesRowMapper.class),
                eq(guideID))
        ).thenReturn(expectedGuide);

        // Method under test
        Guides actualGuide = guidesService.getGuideByID(guideID);

        // Asserting the results
        assertEquals(expectedGuide, actualGuide);

        // Verifying the jdbcTemplate behavior
        verify(jdbcTemplate).queryForObject(
                eq("select * from guidesUsers where GuideUsersID = ?"),
                any(GuidesRowMapper.class),
                eq(guideID));
    }

}
