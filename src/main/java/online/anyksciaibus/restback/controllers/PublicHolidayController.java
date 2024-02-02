package online.anyksciaibus.restback.controllers;

import online.anyksciaibus.restback.repositories.PublicHolidayRepo;
import online.anyksciaibus.restback.services.PublicHolidayService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@RestController
@RequestMapping("/holidays")
@CrossOrigin

public class PublicHolidayController {

    PublicHolidayService service;

    public PublicHolidayController(PublicHolidayService service){
        this.service = service;
    }


    @GetMapping(value = "/checkIfHoliday", produces = "text/html")
    public String checkIfItsHoliday(@RequestParam String dateStr){
        LocalDate date;
        try {
            date = LocalDate.parse(dateStr);
        }catch (DateTimeParseException e){
            return "the date cannot be parsed. Please prodive yyyy-mm-dd<br> e.g. 2024-05-02";
        }

        return service.isTheDayPublicHoliday(date) ? "It is a public holiday" : "no - go to work!";


    }



}
