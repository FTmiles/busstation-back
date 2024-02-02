package online.anyksciaibus.restback.services;

import online.anyksciaibus.restback.dto.SchedItemHomeDto;
import online.anyksciaibus.restback.dto.SingleTrip;
import online.anyksciaibus.restback.dto.SingleStop;
import online.anyksciaibus.restback.entities.*;

import online.anyksciaibus.restback.repositories.ScheduleRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Service
public class ScheduleService {




    ScheduleRepo scheduleRepo;

    public ScheduleService(ScheduleRepo scheduleRepo){
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
    public SingleTrip  getSingleTrip(Long id) {
        LocalTime now = LocalTime.now();
        Optional<Schedule> singleEntityOptional = scheduleRepo.findById(id);

        if (singleEntityOptional.isEmpty()) return null;

        Schedule schedule = singleEntityOptional.get();
        Line line = schedule.getRoute().getLine();

        List<TimePoint> tp = schedule.getTimeArr();
        List<BusStop> bs = schedule.getRoute().getStopsArr();

        if (schedule.getRouteDirReversed())
            Collections.reverse(bs);

        List<SingleStop> stopsList = new ArrayList<>();
        for (int i = 0; i < schedule.getRoute().getStopsArr().size(); i++) {
            stopsList.add(new SingleStop(
                    tp.get(i).getId(), tp.get(i).getTime().toString(), bs.get(i).getName())
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




    public List<SchedItemHomeDto> getScheduleItemsHome(){
        LocalTime now = LocalTime.now();

        List<Schedule> allSchedules = scheduleRepo.findAll();
        return allSchedules.stream().map(entity->{
            SchedItemHomeDto dto = new SchedItemHomeDto();
            dto.setId(entity.getId());
            dto.setDestination(entity.getRoute().getLine().getRouteEnd());
            dto.setTimeDepart(entity.getTimeArr().getFirst().getTime().toString());
            dto.setLineName(entity.getRoute().getLine().getName());

            dto.setTooLate(  now.isAfter(entity.getTimeArr().getFirst().getTime())  );
            return dto;

        }).toList();


    }

}
