package online.anyksciaibus.restback.services;

import online.anyksciaibus.restback.dto.BusStopsDto;
import online.anyksciaibus.restback.entities.BusStop;
import online.anyksciaibus.restback.repositories.BusStopRepo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest
class BusStopServiceTest {
    @Mock
    private BusStopRepo busStopRepo;

    @InjectMocks
    private BusStopService busStopService;

    @Test
    public void testGetSearchOptions_WhenStrIsEmpty() {
        // Mock behavior of busStopRepo.findByDefaultOptionTrue()
        List<BusStop> busStops = new ArrayList<>();
        busStops.add(new BusStop());

        when(busStopRepo.findByDefaultOptionTrue()).thenReturn(busStops);
        // Call the method to test

        List<BusStopsDto> searchOptions = busStopService.getSearchOptions("");

        // Verify that the method returns the expected search options
        assertEquals(busStops.size(), searchOptions.size());
        // You might need to verify the content of the returned DTOs based on your mapping logic
    }
}