package online.anyksciaibus.restback.controllers;


import online.anyksciaibus.restback.dto.SchedItemHomeDto;
import online.anyksciaibus.restback.dto.SingleTrip;
import online.anyksciaibus.restback.dto.scheduling.RunsOnYearlyOptionDto;
import online.anyksciaibus.restback.dto.scheduling.ScheduleDto;
import online.anyksciaibus.restback.entities.BoundFor;
import online.anyksciaibus.restback.entities.Schedule;
import online.anyksciaibus.restback.services.ScheduleService;

import online.anyksciaibus.restback.services.timeconstraints.RunsOnYearlyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/scheduleItem")
@CrossOrigin
public class ScheduleController {


    ScheduleService service;
    RunsOnYearlyService runsOnYearlyService;

    public ScheduleController(ScheduleService service, RunsOnYearlyService runsOnYearlyService) {
        this.service = service;
        this.runsOnYearlyService = runsOnYearlyService;
    }


    @GetMapping("/get/all")
    public List<Schedule> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Schedule> getOne(@PathVariable Long id) {
        Optional<Schedule> data = service.get1ScheduleById(id);
        if (data.isPresent())
            return ResponseEntity.ok(data.get());
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("/save/multi")
    public List<Schedule> saveMulti(@RequestBody List<Schedule> list) {
        return service.saveAll(list);
    }

    @PostMapping("/save/one")
    public Schedule saveOne(@RequestBody Schedule schedule) {
        return service.save1(schedule);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOne(@PathVariable Long id) {
        service.delete1byId(id);
    }


    @DeleteMapping("/delete/multi")
    public void deleteMulti(@RequestBody List<Long> ids) {
        service.deleteMultiple(ids);
    }

    //UPSERT
    @PutMapping("/put/{id}")
    public ResponseEntity<Void> putOne(@PathVariable Long id, @RequestBody Schedule updatedSchedule) {

        Optional<Schedule> existingScheduleOptional = service.get1ScheduleById(id);
        if (existingScheduleOptional.isEmpty() || !id.equals(updatedSchedule.getId()))
            return ResponseEntity.badRequest().build();

        service.save1(updatedSchedule);
        return ResponseEntity.noContent().build();
    }

    //===================================
    @GetMapping("/home/{dateStr}")
    public List<SchedItemHomeDto> getScheduleItemsForHome(@PathVariable String dateStr){
        LocalDate date;
        try{
            date = LocalDate.parse(dateStr);
        }catch (DateTimeParseException e){
            return null;
        }
        return service.getScheduleItemsHome(date);
    }

    @GetMapping("/singleTrip/{id}")
    public SingleTrip getSingleTripApi(@PathVariable Long id){
        return service.getSingleTrip(id);
    }


//    @GetMapping("/schedule-by-line")
//    public List<ScheduleDto> getScheduleByLineId(@RequestParam Long lineId) {
//        return service.getScheduleByLine(lineId)
//                .stream().map(ScheduleDto::scheduleToDto).toList();
//    }

    @GetMapping("/schedule-by-line")
    public Map<String, Object> getScheduleByLineId(@RequestParam Long lineId) {
        //Map.of()  - small up to 10, vs  -  Map.ofEntries(Map.entry("key", new Object()));

        return Map.of(
            //List<ScheduleDto>
            "data" , service.getScheduleByLine(lineId)
                        .stream().map(ScheduleDto::scheduleToDto).toList(),
            //List<BoundFor> used for select
            "boundForOptions", BoundFor.values(),
            //empty ScheduleDto
            "empty", service.getEmptyDto(),
            "yearlyOptions", runsOnYearlyService.getAll().stream()
                        .map(RunsOnYearlyOptionDto::RunsOnYearlyToDto)
                                .collect(Collectors.groupingBy(RunsOnYearlyOptionDto::getTypeOfYearlyRule)),
                "lineTitle", service.findLineNameByLineId(lineId)
        );
    }

    //I think unused, can be deleted
    @GetMapping("/schedule-empty")
    public ScheduleDto getScheduleDtoEmpty() {
//        ScheduleDto dto = ScheduleDto.scheduleToDto(new Schedule());
        return service.getEmptyDto();
    }

    @PostMapping("post-schedule-dto")
    public List<ScheduleDto> postScheduleDto(@RequestBody List<ScheduleDto> scheduleDtoList){
        List<Schedule> response = service.saveAll(scheduleDtoList.stream()
                .map(ScheduleDto::dtoToSchedule).toList());
        return response.stream().map(ScheduleDto::scheduleToDto).toList();
    }
}

