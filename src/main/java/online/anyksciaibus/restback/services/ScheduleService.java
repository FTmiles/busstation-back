package online.anyksciaibus.restback.services;

import online.anyksciaibus.restback.dto.SchedItemHomeDto;
import online.anyksciaibus.restback.entities.Schedule;

import online.anyksciaibus.restback.repositories.ScheduleRepo;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

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
