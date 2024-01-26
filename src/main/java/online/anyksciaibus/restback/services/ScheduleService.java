package online.anyksciaibus.restback.services;

import online.anyksciaibus.restback.repositories.*;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    BusStopRepo busStopRepo;
    LineRepo lineRepo;
    RouteRepo routeRepo;
    ScheduleRepo scheduleRepo;
    TimePointRepo timePointRepo;

    public ScheduleService(BusStopRepo busStopRepo, LineRepo lineRepo, RouteRepo routeRepo, ScheduleRepo scheduleRepo, TimePointRepo timePointRepo){
        this.busStopRepo = busStopRepo;
        this.lineRepo = lineRepo;
        this.routeRepo = routeRepo;
        this.scheduleRepo = scheduleRepo;
        this.timePointRepo = timePointRepo;
    }



}
