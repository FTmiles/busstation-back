package online.anyksciaibus.restback.configuration;

import online.anyksciaibus.restback.entities.*;
import online.anyksciaibus.restback.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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

//        createBusStops();
//        createLine();
//        createRoutes();
        createSchedule();
    }



    public void createBusStops(){
        BusStop bs1 = new BusStop("Anykščių AS", "");
        BusStop bs2 = new BusStop("A. Baranausko a.", "");
        BusStop bs3 = new BusStop("Poliklinika", "");
        BusStop bs4 = new BusStop("Anykščių MSV", "");
        BusStop bs5 = new BusStop("Šlavėnai", "");
        BusStop bs6 = new BusStop("Puntukas", "");
        BusStop bs7 = new BusStop("Gražumynas", "");
        BusStop bs8 = new BusStop("Šližiai", "");
        BusStop bs9 = new BusStop("Pavirinčiai", "");
        BusStop bs10 = new BusStop("Kurkliai", "");
        BusStop bs11 = new BusStop("Moliakalnis", "");
        BusStop bs12 = new BusStop("Staškūniškis", "");

        List<BusStop> bsList = List.of(bs1, bs2, bs3, bs4, bs5, bs6, bs7, bs8, bs9, bs10, bs11, bs12);
        busStopRepo.saveAll(bsList);
    }

    private void createLine() {
        Line line1 = new Line("M17-1", "Anykščiai", "Staškūniškis", "KURKLIUS", "Transporto Centras", "6", "Ask driver", RouteType.REGIONAL_BUS, List.of(new Route()) );
        lineRepo.save(line1);
    }

    public void createRoutes(){

        List<BusStop> stopsArr = new ArrayList<>();
        stopsArr.add(new BusStop(1L));
        stopsArr.add(new BusStop(2L));
        stopsArr.add(new BusStop(3L));
        stopsArr.add(new BusStop(4L));
        stopsArr.add(new BusStop(5L));
        stopsArr.add(new BusStop(6L));
        stopsArr.add(new BusStop(7L));
        stopsArr.add(new BusStop(8L));
        stopsArr.add(new BusStop(9L));
        stopsArr.add(new BusStop(10L));
        stopsArr.add(new BusStop(11L));
        stopsArr.add(new BusStop(12L));

        Line line = new Line();
        line.setId(1L);

        Route route1 = new Route(stopsArr, line);

        routeRepo.save(route1);
    }

    public void createSchedule(){
        Route route1 = new Route();
        route1.setId(4L);
        List<TimePoint> timeArr = new ArrayList<>();

        timeArr.add(new TimePoint(LocalTime.of(8,55)));
        timeArr.add(new TimePoint(LocalTime.of(8,56)));
        timeArr.add(new TimePoint(LocalTime.of(8,58)));
        timeArr.add(new TimePoint(LocalTime.of(9,3)));
        timeArr.add(new TimePoint(LocalTime.of(9,5)));
        timeArr.add(new TimePoint(LocalTime.of(9,7)));
        timeArr.add(new TimePoint(LocalTime.of(9,10)));
        timeArr.add(new TimePoint(LocalTime.of(9,13)));
        timeArr.add(new TimePoint(LocalTime.of(9,15)));
        timeArr.add(new TimePoint(LocalTime.of(9,18)));
        timeArr.add(new TimePoint(LocalTime.of(9,20)));
        timeArr.add(new TimePoint(LocalTime.of(9,25)));

        Schedule schedule = new Schedule(false, false, "vasara", RouteDescr.OUT_BOUND, timeArr, route1);

        scheduleRepo.save(schedule);
    }

}
