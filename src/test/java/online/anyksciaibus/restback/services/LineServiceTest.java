package online.anyksciaibus.restback.services;

import online.anyksciaibus.restback.dto.LinePreviewDto;
import online.anyksciaibus.restback.entities.Line;
import online.anyksciaibus.restback.repositories.LineRepo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class LineServiceTest {

    @Mock
    private LineRepo lineRepo;

    @InjectMocks
    private LineService lineService;

    @Test
    public void testGetLinePreviewDto_WhenLineExists() {
        // Mock data
        Long lineId = 1L;
        Line line = new Line();
        line.setId(lineId);
        line.setName("Test Line");

        // Mock behavior of lineRepo.findById
        when(lineRepo.findById(lineId)).thenReturn(Optional.of(line));


        // Call the method to test
        LinePreviewDto previewDto = lineService.getLinePreviewDto(lineId);

        // Verify that the method returns the expected LinePreviewDto

        assertEquals(line.getName(), previewDto.getName());
        assertEquals(line.getRouteStart(), previewDto.getRouteStart());
    }

    @Test
    public void testGetLinePreviewDto_WhenLineDoesNotExist() {
        // Mock data
        Long lineId = 1L;

        // Mock behavior of lineRepo.findById
        when(lineRepo.findById(lineId)).thenReturn(Optional.empty());
        // Call the method to test
        LinePreviewDto previewDto = lineService.getLinePreviewDto(lineId);

        // Verify that the method returns an empty LinePreviewDto
        assertEquals(null, previewDto.getName(), "checking names");
        assertEquals(null, previewDto.getRouteStart(), "checking routestart");
    }
}