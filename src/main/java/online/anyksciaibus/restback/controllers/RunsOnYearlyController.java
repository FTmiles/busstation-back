package online.anyksciaibus.restback.controllers;

import online.anyksciaibus.restback.dto.scheduling.RunsOnYearlyOptionDto;
import online.anyksciaibus.restback.entities.timeconstraints.RunsOnYearly;
import online.anyksciaibus.restback.entities.timeconstraints.TypeOfYearlyRule;
import online.anyksciaibus.restback.services.timeconstraints.RunsOnYearlyService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.fasterxml.jackson.databind.cfg.CoercionInputShape.Array;

@RestController
@CrossOrigin
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
        List<RunsOnYearly> allRules = service.getAll();
        Map<TypeOfYearlyRule, List<RunsOnYearly>> rules =  allRules.stream()
                .collect(Collectors.groupingBy(RunsOnYearly::getTypeOfYearlyRule));


        return Map.of
                (
                "rules", rules,
                "schedules", service.findScheduleIdsByRunsOnYearly(allRules)
                );
    }

    @PostMapping("/post-combo-list")
    public Map<TypeOfYearlyRule, List<RunsOnYearly>> postListOfYearlyRules(@RequestBody List<RunsOnYearly> list) {
        return service.saveAll(list).stream()
                .collect(Collectors.groupingBy(RunsOnYearly::getTypeOfYearlyRule));
    }

}
