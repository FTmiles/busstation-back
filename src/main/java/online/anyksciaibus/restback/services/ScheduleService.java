package online.anyksciaibus.restback.services;

import online.anyksciaibus.restback.entities.Schedule;

import online.anyksciaibus.restback.repositories.ScheduleRepo;
import org.springframework.stereotype.Service;

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

}
