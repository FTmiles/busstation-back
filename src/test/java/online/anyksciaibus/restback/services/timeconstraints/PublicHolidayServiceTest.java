package online.anyksciaibus.restback.services.timeconstraints;

import online.anyksciaibus.restback.entities.timeconstraints.PublicHoliday;
import online.anyksciaibus.restback.repositories.PublicHolidayRepo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class PublicHolidayServiceTest {

    @Mock
    private PublicHolidayRepo repoMock;

//    @InjectMocks
    private PublicHolidayService service;


    @BeforeEach
    void init(){
        List<PublicHoliday> holidays = List.of(
                new PublicHoliday("New Year", 1, 1),
                new PublicHoliday("Xmas", 12, 25)
        );

        when(repoMock.findAll()).thenReturn(holidays);

        service = new PublicHolidayService(repoMock);
    }

    @Test
    @DisplayName("isTheDayPublicHoliday test")
    void isTheDayPublicHoliday(){
        assertTrue(service.isTheDayPublicHoliday(LocalDate.parse("2024-12-25")));
    }



    @Test
    @DisplayName("calculateEasterDate static test")
    void calculateEasterDate(){
        LocalDate expected = LocalDate.of(2024,3,31);
        assertEquals(expected, PublicHolidayService.calculateEasterDate(2024));
    }


}