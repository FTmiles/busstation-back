package online.anyksciaibus.restback.services;

import jakarta.transaction.Transactional;
import online.anyksciaibus.restback.dto.SchedItemHomeDto;
import online.anyksciaibus.restback.dto.SingleTrip;
import online.anyksciaibus.restback.dto.scheduling.ScheduleDto;
import online.anyksciaibus.restback.dto.scheduling.Trip1WayIdDto;
import online.anyksciaibus.restback.entities.*;

import online.anyksciaibus.restback.entities.timeconstraints.RunsOnYearly;
import online.anyksciaibus.restback.repositories.ScheduleRepo;
import online.anyksciaibus.restback.services.timeconstraints.PublicHolidayService;
import online.anyksciaibus.restback.services.timeconstraints.RunsOnYearlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Optional<Schedule> singleEntityOptional = scheduleRepo.findById(id);

        if (singleEntityOptional.isEmpty()) return new SingleTrip();

        Schedule schedule = singleEntityOptional.get();
        Line line = schedule.getLine();
//
//        List<LocalTime> tp = schedule.getTimeList();
//        List<BusStop> bs = schedule.getRoute().getStopsArr();
//
//        if (schedule.getRouteDirReversed())
//            Collections.reverse(bs);
//
//        List<SingleStop> stopsList = new ArrayList<>();
//        for (int i = 0; i < schedule.getRoute().getStopsArr().size(); i++) {
//            stopsList.add(new SingleStop(
//                    bs.get(i).getId(), tp.get(i).toString(), bs.get(i).getName())
//            );
//        }
//
//        return new SingleTrip(
//                line.getName(),
//                line.getRouteStart(),
//                line.getRouteEnd(),
//                line.getVia(),
//                line.getOperator(),
//                line.getAnykStationPlatform(),
//                line.getPrice(),
//                line.getRouteType().toString(),
//                schedule.getTimeConstraintsDescription(),
//                stopsList
//        );
        return null;
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

        return allSchedules.stream().flatMap(schedule -> {
          List<SchedItemHomeDto> dtoList = SchedItemHomeDto.scheduleTo2Dto(schedule);
            return dtoList.stream();
        }).toList();
    }
    //=================

@Transactional
    public List<Schedule> getScheduleByLine (Long lineId){
        List<Schedule> schedules = scheduleRepo.findByLineId(lineId);

//    schedules.forEach(x-> {
//        x.getTrips().forEach(trip -> trip.getRoute().setDistanceMetersList(null));
//    });
        return schedules;
    }

    public String findLineNameByLineId(Long id){
        Optional<String> nameOptional = scheduleRepo.getLineTitleByLineId(id);
        if (nameOptional.isPresent())
            return nameOptional.get();
        else return "name not found";
    }


    public List<Long> getScheduleIdsByRoute(Route route){
        return scheduleRepo.findScheduleIdsByRoute(route);
    }

    public ScheduleDto getEmptyDto(){
        ScheduleDto dto = ScheduleDto.scheduleToDto(new Schedule());
        Trip1WayIdDto tripDto = new Trip1WayIdDto();
        tripDto.setBoundFor(BoundFor.values()[0]);
        tripDto.setRouteDirReversed(false);
        tripDto.setTimeList(Collections.emptyList());
        dto.setTrips(List.of(tripDto));

        return dto;

    }


}

