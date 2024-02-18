package online.anyksciaibus.restback.controllers;

import online.anyksciaibus.restback.entities.timeconstraints.PublicHoliday;
import online.anyksciaibus.restback.services.timeconstraints.PublicHolidayService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@DisplayName("When testing PublicHolidayController class, ")
public class PublicHolidayControllerTest {


//    @Mock
//    private PublicHolidayService publicHolidayService;
//
//    @InjectMocks
//    private PublicHolidayController publicHolidayController;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testCheckIfItsHoliday_PublicHoliday() {
//        LocalDate date = LocalDate.of(2024, 2, 16);
//        when(publicHolidayService.isTheDayPublicHoliday(date)).thenReturn(true);
//
//        String result = publicHolidayController.checkIfItsHoliday("2024-02-16");
//
//        assertEquals("It is a public holiday", result);
//    }
//
//    @Test
//    public void testCheckIfItsHoliday_NotPublicHoliday() {
//        LocalDate date = LocalDate.of(2024, 2, 17);
//        when(publicHolidayService.isTheDayPublicHoliday(date)).thenReturn(false);
//
//        String result = publicHolidayController.checkIfItsHoliday("2024-02-17");
//
//        assertEquals("no - go to work!", result);
//    }
//
//    @Test
//    public void testCheckIfItsHoliday_InvalidDate() {
//        String result = publicHolidayController.checkIfItsHoliday("invalid-date");
//
//        assertEquals("the date cannot be parsed. Please provide yyyy-mm-dd<br> e.g. 2024-05-02", result);
//    }
//
//    @Test
//    public void testGetAllHolidays() {
//        List<PublicHoliday> holidays = Arrays.asList(new PublicHoliday(), new PublicHoliday());
//        when(publicHolidayService.getAll()).thenReturn(holidays);
//
//        List<PublicHoliday> result = publicHolidayController.getAllHolidays();
//
//        assertEquals(holidays, result);
//    }
//================ ^chatGPT^ ====================


    @Mock
    PublicHolidayService publicHolidayServiceMock;

    @InjectMocks
    PublicHolidayController publicHolidayController;

    @Test
    @DisplayName("getAllHolidays test")
    void getAllHolidaysTest() {
        List<PublicHoliday> expected = List.of(
                new PublicHoliday("Xmas", 12, 25),
                new PublicHoliday("Jonines", 6, 24)
        );

        when(publicHolidayServiceMock.getAll()).thenReturn(expected);
        assertEquals(expected, publicHolidayController.getAllHolidays(), "should return List of all holidays");
    }


    @Test
    @DisplayName("checkIfItsHolida test")
    void checkIfItsHolidayTest() {

        when(publicHolidayServiceMock.isTheDayPublicHoliday(LocalDate.of(2024, 12, 25))).thenReturn(true);
        when(publicHolidayServiceMock.isTheDayPublicHoliday(LocalDate.of(2024, 2, 2))).thenReturn(false);

        assertAll(
                () -> assertEquals("It is a public holiday",
                        publicHolidayController.checkIfItsHoliday("2024-12-25")),

                () -> assertEquals("no - go to work!",
                        publicHolidayController.checkIfItsHoliday("2024-02-02"))
        );

        LocalDate date = LocalDate.of(2024, 2, 17);
        when(publicHolidayServiceMock.isTheDayPublicHoliday(date)).thenReturn(false);

    }


@Test
@DisplayName("saveOneHoliday test")
void saveOneHolidayTest(){
        PublicHoliday holiday = new PublicHoliday("Valentines day", 2, 14);

        when(publicHolidayServiceMock.save1(any(PublicHoliday.class)))
                .thenReturn(holiday);

        PublicHoliday savedHoliday = publicHolidayController.saveOneHoliday(holiday);

    // Verify that the service.save1 method was called with the correct parameter
    verify(publicHolidayServiceMock).save1(holiday);

    assertEquals(holiday, savedHoliday, "saved holiday and holiday don't match");

}



    @Test
    @DisplayName("delete1byId test")
    void delete1byIdTest(){
        Long id = 2L;
        publicHolidayController.deleteOneHoliday(id);
        verify(publicHolidayServiceMock).delete1byId(id);
    }

}
