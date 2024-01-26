package online.anyksciaibus.restback.configuration;

import online.anyksciaibus.restback.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {


    BusStopRepo busStopRepo;
    LineRepo lineRepo;
    RouteRepo routeRepo;
    ScheduleRepo scheduleRepo;
    TimePointRepo timePointRepo;

    public DataLoader(BusStopRepo busStopRepo, LineRepo lineRepo, RouteRepo routeRepo, ScheduleRepo scheduleRepo, TimePointRepo timePointRepo){
        this.busStopRepo = busStopRepo;
        this.lineRepo = lineRepo;
        this.routeRepo = routeRepo;
        this.scheduleRepo = scheduleRepo;
        this.timePointRepo = timePointRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        //loading dummy data


    }
}
