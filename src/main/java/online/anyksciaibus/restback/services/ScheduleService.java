package online.anyksciaibus.restback.services;

import jakarta.transaction.Transactional;
import online.anyksciaibus.restback.controllers.PublicHolidayController;
import online.anyksciaibus.restback.dto.SchedItemHomeDto;
import online.anyksciaibus.restback.dto.SingleTrip;
import online.anyksciaibus.restback.dto.SingleStop;
import online.anyksciaibus.restback.entities.*;

import online.anyksciaibus.restback.entities.timeconstraints.RunsOnYearly;
import online.anyksciaibus.restback.repositories.RunsOnYearlyRepo;
import online.anyksciaibus.restback.repositories.ScheduleRepo;
import online.anyksciaibus.restback.services.timeconstraints.PublicHolidayService;
import online.anyksciaibus.restback.services.timeconstraints.RunsOnYearlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Service
public class ScheduleService {


    ScheduleRepo scheduleRepo;

    public ScheduleService(ScheduleRepo scheduleRepo) {
        this.scheduleRepo = scheduleRepo;
    }


    public List<Schedule> getAll() {
        return scheduleRepo.findAll();
    }

    public Optional<Schedule> get1ScheduleById(Long id) {
        return scheduleRepo.findById(id);
    }

    public List<Schedule> saveAll(List<Schedule> scheduleList) {
        return scheduleRepo.saveAll(scheduleList);
    }

    public Schedule save1(Schedule schedule) {
        return scheduleRepo.save(schedule);
    }

    public void delete1byId(Long id) {
        scheduleRepo.deleteById(id);
    }

    public void deleteMultiple(List<Long> ids) {
        scheduleRepo.deleteAllById(ids);
    }


    //===============================================================
    public SingleTrip getSingleTrip(Long id) {
        LocalTime now = LocalTime.now();
        Optional<Schedule> singleEntityOptional = scheduleRepo.findById(id);

        if (singleEntityOptional.isEmpty()) return new SingleTrip();

        Schedule schedule = singleEntityOptional.get();
        Line line = schedule.getRoute().getLine();

        List<LocalTime> tp = schedule.getTimeList();
        List<BusStop> bs = schedule.getRoute().getStopsArr();

        if (schedule.getRouteDirReversed())
            Collections.reverse(bs);

        List<SingleStop> stopsList = new ArrayList<>();
        for (int i = 0; i < schedule.getRoute().getStopsArr().size(); i++) {
            stopsList.add(new SingleStop(
                    bs.get(i).getId(), tp.get(i).toString(), bs.get(i).getName())
            );
        }

        return new SingleTrip(
                line.getName(),
                line.getRouteStart(),
                line.getRouteEnd(),
                line.getVia(),
                line.getOperator(),
                line.getAnykStationPlatform(),
                line.getPrice(),
                line.getRouteType().toString(),
                schedule.getTimeConstraintsDescription(),
                stopsList
        );
    }

    @Autowired
    PublicHolidayService publicHolidayService;
    @Autowired
    RunsOnYearlyService runsOnYearlyService;

    public List<SchedItemHomeDto> getScheduleItemsHome(LocalDate date) {
        LocalTime now = LocalTime.now();

        boolean isPublicHoliday = publicHolidayService.isTheDayPublicHoliday(date);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        List<RunsOnYearly> runsOnYearlyList = runsOnYearlyService.passingYearlyRulesByDate(date);

        List<Schedule> allSchedules = scheduleRepo.findSchedulesByDayOfWeekAndPublicHolidayAndRunsOnYearly(dayOfWeek, isPublicHoliday, runsOnYearlyList);
        return allSchedules.stream().map(entity -> {
            SchedItemHomeDto dto = new SchedItemHomeDto();
            dto.setId(entity.getId());
            dto.setDestination(entity.getRoute().getLine().getRouteEnd());
            dto.setTimeDepart(entity.getTimeList().getFirst().toString());
            dto.setLineName(entity.getRoute().getLine().getName());

            dto.setTooLate(now.isAfter(entity.getTimeList().getFirst()));
            return dto;

        }).toList();
    }
    //=================

@Transactional
    public List<Schedule> getScheduleByLine (Long lineId){
        List<Schedule> schedules = scheduleRepo.findByRoute_Line_Id(lineId);

        //accessing to fetch lazy data
//        schedules.forEach(x->x.getRoute().getDistanceMetersList().size());
    schedules.forEach(x->x.getRoute().setDistanceMetersList(null));
        return schedules;
    }
}
