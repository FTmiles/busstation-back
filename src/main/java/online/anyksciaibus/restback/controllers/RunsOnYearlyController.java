package online.anyksciaibus.restback.controllers;

import online.anyksciaibus.restback.services.timeconstraints.RunsOnYearlyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Map;

@RestController
@RequestMapping("yearly-rules")
public class RunsOnYearlyController {
    RunsOnYearlyService service;

    public RunsOnYearlyController(RunsOnYearlyService service){
        this.service = service;
    }

    @GetMapping(value = "/rules", produces = "text/html")
    public String getPassingYearlyRules(@RequestParam String dateStr){
        LocalDate date;
        try{
            date = LocalDate.parse(dateStr);
        }catch (DateTimeParseException e){
            return "incorrect date format. try yyyy-mm-dd e.g. 2024-12-07";
        }
        return service.passingYearlyRulesByDate(date).toString();
    }

    @GetMapping("/get-all")
    public Map<String, Object> getAllRules(){
        return Map.of(
                "service.getAll()
    }

}
