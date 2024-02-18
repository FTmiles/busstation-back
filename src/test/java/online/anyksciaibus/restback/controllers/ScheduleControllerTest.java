package online.anyksciaibus.restback.controllers;

import online.anyksciaibus.restback.dto.BusStopsDto;
import online.anyksciaibus.restback.dto.SchedItemHomeDto;
import online.anyksciaibus.restback.entities.BusStop;
import online.anyksciaibus.restback.entities.Schedule;
import online.anyksciaibus.restback.repositories.BusStopRepo;
import online.anyksciaibus.restback.services.BusStopService;
import online.anyksciaibus.restback.services.ScheduleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ScheduleControllerTest {

    @Mock
    ScheduleService serviceMock;

    @InjectMocks
    ScheduleController controller;


    @Test
    @DisplayName("getScheduleItemsForHome test")
    void getScheduleItemsForHomeTest(){
        SchedItemHomeDto dto = new SchedItemHomeDto(2L,"09:20","Mega station","M32",true);

        when(serviceMock.getScheduleItemsHome(any(LocalDate.class)))
                .thenReturn(List.of(dto));

        List<SchedItemHomeDto> output = controller.getScheduleItemsForHome("2024-02-26");

        assertEquals(dto.getId(), output.getFirst().getId(), "id should equal");
    }
}