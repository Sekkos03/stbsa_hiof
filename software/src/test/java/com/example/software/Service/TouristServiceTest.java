package com.example.software.Service;

import com.example.software.Entity.Tourist;
import com.example.software.RowMapper.TouristRowMapper;
import com.example.software.service.TouristService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TouristServiceTest {

    @InjectMocks
    private TouristService touristService;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllTourists() {
        Tourist tourist1 = new Tourist();
        tourist1.setTouristID(1);
        tourist1.setFirstName("John");
        tourist1.setLastName("Doe");
        tourist1.setEmail("john.doe@example.com");
        tourist1.setPhoneNumber(4735826);

        Tourist tourist2 = new Tourist();
        tourist2.setTouristID(2);
        tourist2.setFirstName("Jane");
        tourist2.setLastName("Smith");
        tourist2.setEmail("jane.smith@example.com");
        tourist2.setPhoneNumber(2345678);

        List<Tourist> expectedTourists = Arrays.asList(tourist1, tourist2);

        when(jdbcTemplate.query(eq("select * from tourist"), any(TouristRowMapper.class))).thenReturn(expectedTourists);

        List<Tourist> actualTourists = touristService.getAllTourists();

        verify(jdbcTemplate).query(eq("select * from tourist"), any(TouristRowMapper.class));
        assertEquals(expectedTourists, actualTourists);
    }

    @Test
    public void testGetOneTouristByID() {
        Tourist expectedTourist = new Tourist();
        expectedTourist.setTouristID(1);
        expectedTourist.setFirstName("John");
        expectedTourist.setLastName("Doe");
        expectedTourist.setEmail("john.doe@example.com");
        expectedTourist.setPhoneNumber(4527564);

        when(jdbcTemplate.queryForObject(eq("select * from tourists where touristID = ?"), any(TouristRowMapper.class), eq(1)))
                .thenReturn(expectedTourist);

        Tourist actualTourist = touristService.getOneTouristByID(1);

        verify(jdbcTemplate).queryForObject(eq("select * from tourists where touristID = ?"), any(TouristRowMapper.class), eq(1));
        assertEquals(expectedTourist, actualTourist);
    }
}
