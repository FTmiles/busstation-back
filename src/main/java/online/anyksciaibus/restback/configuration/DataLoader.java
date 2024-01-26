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

        //Line 1
//        createBusStops();
//        createLine();
//        createRoutes();
//        createSchedule();
//
//        createBusStops2();
//        createLine2();
//        createRoutes2();
//        createSchedule2();
//
//        createBusStops3();
//        createLine3();
//        createRoutes3();
//        createSchedule3();
    }



    //<editor-fold desc="LINE 1">
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

        List<DistancePoint> distArr = new ArrayList<>();
        distArr.add(new DistancePoint(1000));
        distArr.add(new DistancePoint(500));
        distArr.add(new DistancePoint(2400));
        distArr.add(new DistancePoint(1400));
        distArr.add(new DistancePoint(2000));
        distArr.add(new DistancePoint(2500));
        distArr.add(new DistancePoint(1600));
        distArr.add(new DistancePoint(3000));
        distArr.add(new DistancePoint(2300));
        distArr.add(new DistancePoint(2400));

        Route route1 = new Route(stopsArr, distArr, line, "");

        routeRepo.save(route1);
    }

    public void createSchedule(){
        schedule1();
        schedule2();
        schedule3();
        schedule4();
    }
        public void schedule1(){
            Route route1 = new Route();
            route1.setId(1L);
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

            Schedule schedule = new Schedule(false, false, "važiuoja moksleivių atostogų metu", BoundFor.OUT_BOUND, timeArr, route1);

            scheduleRepo.save(schedule);
        }

    public void schedule2(){
        Route route1 = new Route();
        route1.setId(1L);
        List<TimePoint> timeArr = new ArrayList<>();

        timeArr.add(new TimePoint(LocalTime.of(9,25)));
        timeArr.add(new TimePoint(LocalTime.of(9,28)));
        timeArr.add(new TimePoint(LocalTime.of(9,30)));
        timeArr.add(new TimePoint(LocalTime.of(9,32)));
        timeArr.add(new TimePoint(LocalTime.of(9,34)));
        timeArr.add(new TimePoint(LocalTime.of(9,36)));
        timeArr.add(new TimePoint(LocalTime.of(9,38)));
        timeArr.add(new TimePoint(LocalTime.of(9,40)));
        timeArr.add(new TimePoint(LocalTime.of(9,42)));
        timeArr.add(new TimePoint(LocalTime.of(9,46)));
        timeArr.add(new TimePoint(LocalTime.of(9,48)));
        timeArr.add(new TimePoint(LocalTime.of(9,50)));

        Schedule schedule = new Schedule(true, false, "važiuoja moksleivių atostogų metu", BoundFor.CITY_BOUND, timeArr, route1);

        scheduleRepo.save(schedule);
    }
    public void schedule3(){
        Route route1 = new Route();
        route1.setId(1L);
        List<TimePoint> timeArr = new ArrayList<>();

        timeArr.add(new TimePoint(LocalTime.of(13,30)));
        timeArr.add(new TimePoint(LocalTime.of(13,31)));
        timeArr.add(new TimePoint(LocalTime.of(13,33)));
        timeArr.add(new TimePoint(LocalTime.of(13,35)));
        timeArr.add(new TimePoint(LocalTime.of(13,37)));
        timeArr.add(new TimePoint(LocalTime.of(13,39)));
        timeArr.add(new TimePoint(LocalTime.of(13,41)));
        timeArr.add(new TimePoint(LocalTime.of(13,43)));
        timeArr.add(new TimePoint(LocalTime.of(13,45)));
        timeArr.add(new TimePoint(LocalTime.of(13,47)));
        timeArr.add(new TimePoint(LocalTime.of(13,49)));
        timeArr.add(new TimePoint(LocalTime.of(13,54)));

        Schedule schedule = new Schedule(false, false, "važiuoja darbo dienomis", BoundFor.OUT_BOUND, timeArr, route1);

        scheduleRepo.save(schedule);
    }

    public void schedule4(){
        Route route1 = new Route();
        route1.setId(1L);
        List<TimePoint> timeArr = new ArrayList<>();

        timeArr.add(new TimePoint(LocalTime.of(13,55)));
        timeArr.add(new TimePoint(LocalTime.of(13,58)));
        timeArr.add(new TimePoint(LocalTime.of(14,0)));
        timeArr.add(new TimePoint(LocalTime.of(14,3)));
        timeArr.add(new TimePoint(LocalTime.of(14,6)));
        timeArr.add(new TimePoint(LocalTime.of(14,8)));
        timeArr.add(new TimePoint(LocalTime.of(14,10)));
        timeArr.add(new TimePoint(LocalTime.of(14,13)));
        timeArr.add(new TimePoint(LocalTime.of(14,15)));
        timeArr.add(new TimePoint(LocalTime.of(14,17)));
        timeArr.add(new TimePoint(LocalTime.of(14,19)));
        timeArr.add(new TimePoint(LocalTime.of(14,20)));

        Schedule schedule = new Schedule(true, false, "važiuoja darbo dienomis", BoundFor.CITY_BOUND, timeArr, route1);

        scheduleRepo.save(schedule);
    }
    //</editor-fold>
//=====================================================

    //<editor-fold desc="LINE 2">
    public void createBusStops2(){
            BusStop bs1 = new BusStop("Technologijos m.", "");
            BusStop bs2 = new BusStop("Šeimyniškiai", "");
            BusStop bs3 = new BusStop("Ažuožeriai", "");
            BusStop bs4 = new BusStop("Vaivadiškiai", "");
            BusStop bs5 = new BusStop("Zavesiškis", "");
            BusStop bs6 = new BusStop("Bebrūnai", "");
            BusStop bs7 = new BusStop("Kavarskas", "");
            BusStop bs8 = new BusStop("Janušava", "");
            BusStop bs9 = new BusStop("Gintaras", "");
            BusStop bs10 = new BusStop("Girninkija", "");
            BusStop bs11 = new BusStop("Pienionys", "");
            BusStop bs12 = new BusStop("Malgažatava", "");
            BusStop bs13 = new BusStop("Mokinių st.v.", "");
            BusStop bs14 = new BusStop("Repšėnai", "");
            BusStop bs15 = new BusStop("Degionys", "");
            BusStop bs16 = new BusStop("Pusbačkiai", "");
            BusStop bs17 = new BusStop("Surdaugiai", "");
            BusStop bs18 = new BusStop("Traupis", "");
            BusStop bs19 = new BusStop("Janapolis", "");
            BusStop bs20 = new BusStop("Levaniškis", "");
            BusStop bs21 = new BusStop("Vežiškiai", "");
            BusStop bs22 = new BusStop("Raguvos kr.", "");
            BusStop bs23 = new BusStop("Raguva", "");
            BusStop bs24 = new BusStop("Girelė", "");
            BusStop bs25 = new BusStop("Degsniai", "");
            BusStop bs26 = new BusStop("Žalioji", "");
            BusStop bs27 = new BusStop("Troškūnai", "");
            BusStop bs28 = new BusStop("Aukštakalnis", "");
            BusStop bs29 = new BusStop("Smėlynė I", "");
            BusStop bs30 = new BusStop("Smėlynė II", "");
            BusStop bs31 = new BusStop("Kryžkelė", "");
            BusStop bs32 = new BusStop("Naujonys", "");
            BusStop bs33 = new BusStop("Piktagalys", "");
            BusStop bs34 = new BusStop("Kuniškiai", "");
            BusStop bs35 = new BusStop("Vikonys", "");
            BusStop bs36 = new BusStop("Vėjališkis", "");

            List<BusStop> bsList = List.of(bs1, bs2, bs3, bs4, bs5, bs6, bs7, bs8, bs9, bs10, bs11, bs12, bs13, bs14, bs15, bs16, bs17, bs18, bs19, bs20, bs21, bs22, bs23, bs24, bs25, bs26, bs27, bs28, bs29, bs30, bs31, bs32, bs33, bs34, bs35, bs36);

            busStopRepo.saveAll(bsList);
        }

        private void createLine2() {
            Line line1 = new Line("M18-1-1", "Anykščiai AS", "Anykščiai AS", "Raguva, Troškūnai", "Transporto Centras", "1", "Ask driver", RouteType.REGIONAL_BUS, List.of(new Route()) );
            lineRepo.save(line1);
        }

        private void createRoutes2() {
            List<BusStop> stopsArr = new ArrayList<>();
            stopsArr.add(new BusStop(1L));
            stopsArr.add(new BusStop(13L));
            stopsArr.add(new BusStop(14L));
            stopsArr.add(new BusStop(15L));
            stopsArr.add(new BusStop(16L));
            stopsArr.add(new BusStop(17L));
            stopsArr.add(new BusStop(18L));
            stopsArr.add(new BusStop(19L));
            stopsArr.add(new BusStop(20L));
            stopsArr.add(new BusStop(21L));
            stopsArr.add(new BusStop(22L));
            stopsArr.add(new BusStop(23L));
            stopsArr.add(new BusStop(24L));
            stopsArr.add(new BusStop(25L));
            stopsArr.add(new BusStop(26L));
            stopsArr.add(new BusStop(27L));
            stopsArr.add(new BusStop(28L));
            stopsArr.add(new BusStop(29L));
            stopsArr.add(new BusStop(30L));
            stopsArr.add(new BusStop(31L));
            stopsArr.add(new BusStop(32L));
            stopsArr.add(new BusStop(33L));
            stopsArr.add(new BusStop(34L));
            stopsArr.add(new BusStop(35L));
            stopsArr.add(new BusStop(34L));
            stopsArr.add(new BusStop(33L));
            stopsArr.add(new BusStop(32L));
            stopsArr.add(new BusStop(31L));
            stopsArr.add(new BusStop(30L));
            stopsArr.add(new BusStop(36L));
            stopsArr.add(new BusStop(37L));
            stopsArr.add(new BusStop(38L));
            stopsArr.add(new BusStop(39L));
            stopsArr.add(new BusStop(40L));
            stopsArr.add(new BusStop(41L));
            stopsArr.add(new BusStop(42L));
            stopsArr.add(new BusStop(43L));
            stopsArr.add(new BusStop(44L));
            stopsArr.add(new BusStop(45L));
            stopsArr.add(new BusStop(46L));
            stopsArr.add(new BusStop(47L));
            stopsArr.add(new BusStop(48L));
            stopsArr.add(new BusStop(1L));

            Line line = new Line();
            line.setId(2L);

            List<DistancePoint> distArr = new ArrayList<>();
            distArr.add(new DistancePoint(1500));
            distArr.add(new DistancePoint(2400));
            distArr.add(new DistancePoint(2100));
            distArr.add(new DistancePoint(3000));
            distArr.add(new DistancePoint(2000));
            distArr.add(new DistancePoint(3000));
            distArr.add(new DistancePoint(2000));
            distArr.add(new DistancePoint(2300));
            distArr.add(new DistancePoint(500));
            distArr.add(new DistancePoint(1100));
            distArr.add(new DistancePoint(2200));
            distArr.add(new DistancePoint(3000));
            distArr.add(new DistancePoint(1200));
            distArr.add(new DistancePoint(800));
            distArr.add(new DistancePoint(1000));
            distArr.add(new DistancePoint(2400));
            distArr.add(new DistancePoint(900));
            distArr.add(new DistancePoint(2200));
            distArr.add(new DistancePoint(2700));
            distArr.add(new DistancePoint(1500));
            distArr.add(new DistancePoint(2700));
            distArr.add(new DistancePoint(2500));
            distArr.add(new DistancePoint(1000));
            distArr.add(new DistancePoint(1000));
            distArr.add(new DistancePoint(2500));
            distArr.add(new DistancePoint(2700));
            distArr.add(new DistancePoint(1600));
            distArr.add(new DistancePoint(2600));
            distArr.add(new DistancePoint(3500));
            distArr.add(new DistancePoint(1900));
            distArr.add(new DistancePoint(2900));
            distArr.add(new DistancePoint(4600));
            distArr.add(new DistancePoint(1500));
            distArr.add(new DistancePoint(1500));
            distArr.add(new DistancePoint(2600));
            distArr.add(new DistancePoint(2300));
            distArr.add(new DistancePoint(1300));
            distArr.add(new DistancePoint(2700));
            distArr.add(new DistancePoint(1400));
            distArr.add(new DistancePoint(1200));
            distArr.add(new DistancePoint(800));
            distArr.add(new DistancePoint(3000));


            Route route1 = new Route(stopsArr, distArr, line, "");

            routeRepo.save(route1);
        }

        private void createSchedule2() {
            Route route1 = new Route();
            route1.setId(2L);
            List<TimePoint> timeArr = new ArrayList<>();

            timeArr.add(new TimePoint(LocalTime.of(7,20)));
            timeArr.add(new TimePoint(LocalTime.of(7,22)));
            timeArr.add(new TimePoint(LocalTime.of(7,24)));
            timeArr.add(new TimePoint(LocalTime.of(7,25)));
            timeArr.add(new TimePoint(LocalTime.of(7,29)));
            timeArr.add(new TimePoint(LocalTime.of(7,30)));
            timeArr.add(new TimePoint(LocalTime.of(7,33)));
            timeArr.add(new TimePoint(LocalTime.of(7,35)));
            timeArr.add(new TimePoint(LocalTime.of(7,38)));
            timeArr.add(new TimePoint(LocalTime.of(7,40)));
            timeArr.add(new TimePoint(LocalTime.of(7,42)));
            timeArr.add(new TimePoint(LocalTime.of(7,45)));
            timeArr.add(new TimePoint(LocalTime.of(7,48)));
            timeArr.add(new TimePoint(LocalTime.of(7,49)));
            timeArr.add(new TimePoint(LocalTime.of(7,50)));
            timeArr.add(new TimePoint(LocalTime.of(7,51)));
            timeArr.add(new TimePoint(LocalTime.of(7,53)));
            timeArr.add(new TimePoint(LocalTime.of(7,54)));
            timeArr.add(new TimePoint(LocalTime.of(7,55)));
            timeArr.add(new TimePoint(LocalTime.of(7,57)));
            timeArr.add(new TimePoint(LocalTime.of(7,59)));
            timeArr.add(new TimePoint(LocalTime.of(8,2)));
            timeArr.add(new TimePoint(LocalTime.of(8,4)));
            timeArr.add(new TimePoint(LocalTime.of(8,5)));
            timeArr.add(new TimePoint(LocalTime.of(8,6)));
            timeArr.add(new TimePoint(LocalTime.of(8,8)));
            timeArr.add(new TimePoint(LocalTime.of(8,12)));
            timeArr.add(new TimePoint(LocalTime.of(8,15)));
            timeArr.add(new TimePoint(LocalTime.of(8,20)));
            timeArr.add(new TimePoint(LocalTime.of(8,22)));
            timeArr.add(new TimePoint(LocalTime.of(8,26)));
            timeArr.add(new TimePoint(LocalTime.of(8,34)));
            timeArr.add(new TimePoint(LocalTime.of(8,42)));
            timeArr.add(new TimePoint(LocalTime.of(8,45)));
            timeArr.add(new TimePoint(LocalTime.of(8,48)));
            timeArr.add(new TimePoint(LocalTime.of(8,53)));
            timeArr.add(new TimePoint(LocalTime.of(8,55)));
            timeArr.add(new TimePoint(LocalTime.of(9,0)));
            timeArr.add(new TimePoint(LocalTime.of(9,6)));
            timeArr.add(new TimePoint(LocalTime.of(9,9)));
            timeArr.add(new TimePoint(LocalTime.of(9,12)));
            timeArr.add(new TimePoint(LocalTime.of(9,13)));
            timeArr.add(new TimePoint(LocalTime.of(9,20)));


            Schedule schedule = new Schedule(false, false, "Autobusas važiuoja trečiadieniais", BoundFor.CIRCLE, timeArr, route1);

            scheduleRepo.save(schedule);

            //============================================= second schedule, afternoon

            Route route2 = new Route();
            route2.setId(2L);
            List<TimePoint> timeArr2 = new ArrayList<>();

            timeArr2.add(new TimePoint(LocalTime.of(13,30)));
            timeArr2.add(new TimePoint(LocalTime.of(13,32)));
            timeArr2.add(new TimePoint(LocalTime.of(13,35)));
            timeArr2.add(new TimePoint(LocalTime.of(13,38)));
            timeArr2.add(new TimePoint(LocalTime.of(13,41)));
            timeArr2.add(new TimePoint(LocalTime.of(13,49)));
            timeArr2.add(new TimePoint(LocalTime.of(13,52)));
            timeArr2.add(new TimePoint(LocalTime.of(13,56)));
            timeArr2.add(new TimePoint(LocalTime.of(13,59)));
            timeArr2.add(new TimePoint(LocalTime.of(14,2)));
            timeArr2.add(new TimePoint(LocalTime.of(14,5)));
            timeArr2.add(new TimePoint(LocalTime.of(14,10)));
            timeArr2.add(new TimePoint(LocalTime.of(14,15)));
            timeArr2.add(new TimePoint(LocalTime.of(14,20)));
            timeArr2.add(new TimePoint(LocalTime.of(14,30)));
            timeArr2.add(new TimePoint(LocalTime.of(14,32)));
            timeArr2.add(new TimePoint(LocalTime.of(14,35)));
            timeArr2.add(new TimePoint(LocalTime.of(14,38)));
            timeArr2.add(new TimePoint(LocalTime.of(14,40)));
            timeArr2.add(new TimePoint(LocalTime.of(14,45)));
            timeArr2.add(new TimePoint(LocalTime.of(14,47)));
            timeArr2.add(new TimePoint(LocalTime.of(14,49)));
            timeArr2.add(new TimePoint(LocalTime.of(14,51)));
            timeArr2.add(new TimePoint(LocalTime.of(14,55)));
            timeArr2.add(new TimePoint(LocalTime.of(15,0)));
            timeArr2.add(new TimePoint(LocalTime.of(15,1)));
            timeArr2.add(new TimePoint(LocalTime.of(15,2)));
            timeArr2.add(new TimePoint(LocalTime.of(15,3)));
            timeArr2.add(new TimePoint(LocalTime.of(15,5)));
            timeArr2.add(new TimePoint(LocalTime.of(15,7)));
            timeArr2.add(new TimePoint(LocalTime.of(15,8)));
            timeArr2.add(new TimePoint(LocalTime.of(15,10)));
            timeArr2.add(new TimePoint(LocalTime.of(15,12)));
            timeArr2.add(new TimePoint(LocalTime.of(15,13)));
            timeArr2.add(new TimePoint(LocalTime.of(15,14)));
            timeArr2.add(new TimePoint(LocalTime.of(15,15)));
            timeArr2.add(new TimePoint(LocalTime.of(15,18)));
            timeArr2.add(new TimePoint(LocalTime.of(15,22)));
            timeArr2.add(new TimePoint(LocalTime.of(15,25)));
            timeArr2.add(new TimePoint(LocalTime.of(15,27)));
            timeArr2.add(new TimePoint(LocalTime.of(15,30)));
            timeArr2.add(new TimePoint(LocalTime.of(15,32)));
            timeArr2.add(new TimePoint(LocalTime.of(15,35)));


            Schedule schedule2 = new Schedule(true, false, "Autobusas važiuoja trečiadieniais", BoundFor.CIRCLE, timeArr2, route2);

            scheduleRepo.save(schedule2);
        }
    //</editor-fold>
//=======================================================

    public void createBusStops3(){
        BusStop  bs1 = new BusStop("A.Vienuolio prog.", "");
        BusStop  bs2 = new BusStop("Stadijonas", "");
        BusStop  bs3 = new BusStop("SB ,,Voruta“", "");
        BusStop  bs4 = new BusStop("Elmininkai", "");
        BusStop  bs5 = new BusStop("Bikūnai", "");
        BusStop  bs6 = new BusStop("S.Elmininkai", "");
        BusStop  bs7 = new BusStop("Vosgėliai", "");
        BusStop  bs8 = new BusStop("Čekonys I", "");
        BusStop  bs9 = new BusStop("Čekonys II", "");
        BusStop bs10 = new BusStop("Kalveliai", "");
        BusStop bs11 = new BusStop("Meldučiai", "");
        BusStop bs12 = new BusStop("Debeikiai", "");
        BusStop bs13 = new BusStop("Jurzdikas", "");
        BusStop bs14 = new BusStop("Aknystų kr.", "");
        BusStop bs15 = new BusStop("Aknystos", "");

        BusStop bs16 = new BusStop("Šližiai", "");
        BusStop bs17 = new BusStop("Varkujai", "");



        List<BusStop> bsList = List.of(bs1, bs2, bs3, bs4, bs5, bs6, bs7, bs8, bs9, bs10, bs11, bs12, bs13, bs14, bs15, bs16, bs17);

        busStopRepo.saveAll(bsList);
    }

    private void createLine3() {
        Line line1 = new Line("M22", "ANYKŠČIAI", "VARKUJAI ", "DEBEIKIUS, AKNYSTAS", "Transporto Centras", "3", "Ask driver", RouteType.REGIONAL_BUS, List.of(new Route()) );
        lineRepo.save(line1);
    }

    private void createRoutes3() {
        newRoute3_1();
        newRoute3_2();
        newRoute3_3();
    }

    public void newRoute3_1(){
        List<BusStop> stopsArr = new ArrayList<>();
        stopsArr.add(new BusStop(65L));
        stopsArr.add(new BusStop(64L));
        stopsArr.add(new BusStop(62L));
        stopsArr.add(new BusStop(63L));
        stopsArr.add(new BusStop(62L));
        stopsArr.add(new BusStop(61L));
        stopsArr.add(new BusStop(60L));
        stopsArr.add(new BusStop(59L));
        stopsArr.add(new BusStop(58L));
        stopsArr.add(new BusStop(57L));
        stopsArr.add(new BusStop(56L));
        stopsArr.add(new BusStop(55L));
        stopsArr.add(new BusStop(54L));
        stopsArr.add(new BusStop(53L));
        stopsArr.add(new BusStop(52L));
        stopsArr.add(new BusStop(51L));
        stopsArr.add(new BusStop(50L));
        stopsArr.add(new BusStop(49L));
        stopsArr.add(new BusStop(2L));
        stopsArr.add(new BusStop(1L));


        Line line = new Line();
        line.setId(3L);

        List<DistancePoint> distArr = new ArrayList<>();
        distArr.add(new DistancePoint(1500));
        distArr.add(new DistancePoint(1500));
        distArr.add(new DistancePoint(900));
        distArr.add(new DistancePoint(900));
        distArr.add(new DistancePoint(1100));
        distArr.add(new DistancePoint(1900));
        distArr.add(new DistancePoint(1500));
        distArr.add(new DistancePoint(1600));
        distArr.add(new DistancePoint(2500));
        distArr.add(new DistancePoint(1100));
        distArr.add(new DistancePoint(2600));
        distArr.add(new DistancePoint(1700));
        distArr.add(new DistancePoint(3000));
        distArr.add(new DistancePoint(1300));
        distArr.add(new DistancePoint(1000));
        distArr.add(new DistancePoint(1900));
        distArr.add(new DistancePoint(1000));
        distArr.add(new DistancePoint(500));
        distArr.add(new DistancePoint(500));


        Route route1 = new Route(stopsArr, distArr, line, "");

        routeRepo.save(route1);
    }
    public void newRoute3_2(){
        List<BusStop> stopsArr = new ArrayList<>();
        stopsArr.add(new BusStop(1L));
        stopsArr.add(new BusStop(2L));
        stopsArr.add(new BusStop(49L));
        stopsArr.add(new BusStop(50L));
        stopsArr.add(new BusStop(51L));
        stopsArr.add(new BusStop(52L));
        stopsArr.add(new BusStop(53L));
        //no S.Elmininkai
        stopsArr.add(new BusStop(55L));
        stopsArr.add(new BusStop(56L));
        stopsArr.add(new BusStop(57L));
        stopsArr.add(new BusStop(58L));
        stopsArr.add(new BusStop(59L));
        stopsArr.add(new BusStop(60L));
        stopsArr.add(new BusStop(61L));
        stopsArr.add(new BusStop(62L));
        stopsArr.add(new BusStop(63L));
        stopsArr.add(new BusStop(62L));
        stopsArr.add(new BusStop(64L));
        stopsArr.add(new BusStop(65L));


        Line line = new Line();
        line.setId(3L);

        List<DistancePoint> distArr = new ArrayList<>();
        distArr.add(new DistancePoint(500));
        distArr.add(new DistancePoint(500));
        distArr.add(new DistancePoint(1000));
        distArr.add(new DistancePoint(1900));
        distArr.add(new DistancePoint(1000));
        distArr.add(new DistancePoint(1300));
        //no S.Elmininkai
        distArr.add(new DistancePoint(1700));
        distArr.add(new DistancePoint(2600));
        distArr.add(new DistancePoint(1100));
        distArr.add(new DistancePoint(2500));
        distArr.add(new DistancePoint(1600));
        distArr.add(new DistancePoint(1500));
        distArr.add(new DistancePoint(1900));
        distArr.add(new DistancePoint(1100));
        distArr.add(new DistancePoint(900));
        distArr.add(new DistancePoint(900));
        distArr.add(new DistancePoint(1500));
        distArr.add(new DistancePoint(1500));



        Route route1 = new Route(stopsArr, distArr, line, "be S.Elmininku");

        routeRepo.save(route1);
    }
    public void newRoute3_3(){
        List<BusStop> stopsArr = new ArrayList<>();
        stopsArr.add(new BusStop(1L));
        stopsArr.add(new BusStop(2L));
        stopsArr.add(new BusStop(49L));
        stopsArr.add(new BusStop(50L));
        stopsArr.add(new BusStop(51L));
        stopsArr.add(new BusStop(52L));
        stopsArr.add(new BusStop(53L));
        //no S.Elmininkai
        stopsArr.add(new BusStop(55L));
        stopsArr.add(new BusStop(56L));
        stopsArr.add(new BusStop(57L));
        stopsArr.add(new BusStop(58L));
        stopsArr.add(new BusStop(59L));
        stopsArr.add(new BusStop(60L));
        stopsArr.add(new BusStop(61L));
        stopsArr.add(new BusStop(62L));
        //no Aknystos
        //no Aknystu kr.
        stopsArr.add(new BusStop(64L));
        stopsArr.add(new BusStop(65L));


        Line line = new Line();
        line.setId(3L);

        List<DistancePoint> distArr = new ArrayList<>();
        distArr.add(new DistancePoint(500));
        distArr.add(new DistancePoint(500));
        distArr.add(new DistancePoint(1000));
        distArr.add(new DistancePoint(1900));
        distArr.add(new DistancePoint(1000));
        distArr.add(new DistancePoint(1300));
        //no S.Elmininkai
        distArr.add(new DistancePoint(1700));
        distArr.add(new DistancePoint(2600));
        distArr.add(new DistancePoint(1100));
        distArr.add(new DistancePoint(2500));
        distArr.add(new DistancePoint(1600));
        distArr.add(new DistancePoint(1500));
        distArr.add(new DistancePoint(1900));
        distArr.add(new DistancePoint(1100));
        //no Aknystos
        //no Aknystu kr.
        distArr.add(new DistancePoint(1500));
        distArr.add(new DistancePoint(1500));



        Route route1 = new Route(stopsArr, distArr, line, "be S. Elmininku, Aknystos, Aknystu kr.");

        routeRepo.save(route1);
    }

    private void createSchedule3() {
        newSchedule3_1();
        newSchedule3_2();
        newSchedule3_3();
        newSchedule3_4();
        newSchedule3_5();
        newSchedule3_6();

    }
    private void newSchedule3_1(){
        Route route1 = new Route();
        route1.setId(5L);
        List<TimePoint> timeArr = new ArrayList<>();

        timeArr.add(new TimePoint(LocalTime.of(6,30)));
        timeArr.add(new TimePoint(LocalTime.of(6,31)));
        timeArr.add(new TimePoint(LocalTime.of(6,32)));
        timeArr.add(new TimePoint(LocalTime.of(6,34)));
        timeArr.add(new TimePoint(LocalTime.of(6,35)));
        timeArr.add(new TimePoint(LocalTime.of(6,36)));
        timeArr.add(new TimePoint(LocalTime.of(6,39)));
        timeArr.add(new TimePoint(LocalTime.of(6,40)));
        timeArr.add(new TimePoint(LocalTime.of(6,41)));
        timeArr.add(new TimePoint(LocalTime.of(6,42)));
        timeArr.add(new TimePoint(LocalTime.of(6,44)));
        timeArr.add(new TimePoint(LocalTime.of(6,45)));
        timeArr.add(new TimePoint(LocalTime.of(6,48)));
        timeArr.add(new TimePoint(LocalTime.of(6,50)));
        timeArr.add(new TimePoint(LocalTime.of(6,51)));
        timeArr.add(new TimePoint(LocalTime.of(6,53)));
        timeArr.add(new TimePoint(LocalTime.of(6,55)));


        Schedule schedule = new Schedule(false, false, "važiuoja darbo dienomis", BoundFor.OUT_BOUND, timeArr, route1);

        scheduleRepo.save(schedule);
    }
    private void newSchedule3_2(){
        Route route1 = new Route();
        route1.setId(5L);
        List<TimePoint> timeArr = new ArrayList<>();

        timeArr.add(new TimePoint(LocalTime.of(6,55)));
        timeArr.add(new TimePoint(LocalTime.of(6,58)));
        timeArr.add(new TimePoint(LocalTime.of(7,2)));
        timeArr.add(new TimePoint(LocalTime.of(7,8)));
        timeArr.add(new TimePoint(LocalTime.of(7,10)));
        timeArr.add(new TimePoint(LocalTime.of(7,12)));
        timeArr.add(new TimePoint(LocalTime.of(7,18)));
        timeArr.add(new TimePoint(LocalTime.of(7,20)));
        timeArr.add(new TimePoint(LocalTime.of(7,22)));
        timeArr.add(new TimePoint(LocalTime.of(7,24)));
        timeArr.add(new TimePoint(LocalTime.of(7,26)));
        timeArr.add(new TimePoint(LocalTime.of(7,30)));
        timeArr.add(new TimePoint(LocalTime.of(7,35)));
        timeArr.add(new TimePoint(LocalTime.of(7,38)));
        timeArr.add(new TimePoint(LocalTime.of(7,40)));
        timeArr.add(new TimePoint(LocalTime.of(7,42)));
        timeArr.add(new TimePoint(LocalTime.of(7,44)));
        timeArr.add(new TimePoint(LocalTime.of(7,45)));
        timeArr.add(new TimePoint(LocalTime.of(7,48)));
        timeArr.add(new TimePoint(LocalTime.of(7,50)));

        Schedule schedule = new Schedule(false, false, "važiuoja darbo dienomis", BoundFor.CITY_BOUND, timeArr, route1);

        scheduleRepo.save(schedule);
    }
    private void newSchedule3_3(){
        Route route1 = new Route();
        route1.setId(5L);
        List<TimePoint> timeArr = new ArrayList<>();

        timeArr.add(new TimePoint(LocalTime.of(13,50)));
        timeArr.add(new TimePoint(LocalTime.of(13,52)));
        timeArr.add(new TimePoint(LocalTime.of(13,55)));
        timeArr.add(new TimePoint(LocalTime.of(13,58)));
        timeArr.add(new TimePoint(LocalTime.of(14,0)));
        timeArr.add(new TimePoint(LocalTime.of(14,2)));
        timeArr.add(new TimePoint(LocalTime.of(14,5)));
        timeArr.add(new TimePoint(LocalTime.of(14,7)));
        timeArr.add(new TimePoint(LocalTime.of(14,9)));
        timeArr.add(new TimePoint(LocalTime.of(14,10)));
        timeArr.add(new TimePoint(LocalTime.of(14,12)));
        timeArr.add(new TimePoint(LocalTime.of(14,14)));
        timeArr.add(new TimePoint(LocalTime.of(14,16)));
        timeArr.add(new TimePoint(LocalTime.of(14,18)));
        timeArr.add(new TimePoint(LocalTime.of(14,20)));
        timeArr.add(new TimePoint(LocalTime.of(14,26)));
        timeArr.add(new TimePoint(LocalTime.of(14,28)));


        Schedule schedule = new Schedule(false, false, "važiuoja mokslo metu", BoundFor.OUT_BOUND, timeArr, route1);

        scheduleRepo.save(schedule);
    }
    private void newSchedule3_4(){
        Route route1 = new Route();
        route1.setId(4L);
        List<TimePoint> timeArr = new ArrayList<>();

        timeArr.add(new TimePoint(LocalTime.of(14,30)));
        timeArr.add(new TimePoint(LocalTime.of(14,32)));
        timeArr.add(new TimePoint(LocalTime.of(14,34)));
        timeArr.add(new TimePoint(LocalTime.of(14,36)));
        timeArr.add(new TimePoint(LocalTime.of(14,38)));
        timeArr.add(new TimePoint(LocalTime.of(14,40)));
        timeArr.add(new TimePoint(LocalTime.of(14,42)));
        timeArr.add(new TimePoint(LocalTime.of(14,44)));
        timeArr.add(new TimePoint(LocalTime.of(14,46)));
        timeArr.add(new TimePoint(LocalTime.of(14,48)));
        timeArr.add(new TimePoint(LocalTime.of(14,50)));
        timeArr.add(new TimePoint(LocalTime.of(14,52)));
        timeArr.add(new TimePoint(LocalTime.of(14,54)));
        timeArr.add(new TimePoint(LocalTime.of(14,56)));
        timeArr.add(new TimePoint(LocalTime.of(14,58)));
        timeArr.add(new TimePoint(LocalTime.of(15,0)));
        timeArr.add(new TimePoint(LocalTime.of(15,3)));
        timeArr.add(new TimePoint(LocalTime.of(15,6)));
        timeArr.add(new TimePoint(LocalTime.of(15,8)));

        Schedule schedule = new Schedule(true, false, "važiuoja mokslo metu", BoundFor.CITY_BOUND, timeArr, route1);

        scheduleRepo.save(schedule);
    }
    private void newSchedule3_5(){
        Route route1 = new Route();
        route1.setId(4L);
        List<TimePoint> timeArr = new ArrayList<>();

        timeArr.add(new TimePoint(LocalTime.of(16,0)));
        timeArr.add(new TimePoint(LocalTime.of(16,2)));
        timeArr.add(new TimePoint(LocalTime.of(16,3)));
        timeArr.add(new TimePoint(LocalTime.of(16,5)));
        timeArr.add(new TimePoint(LocalTime.of(16,7)));
        timeArr.add(new TimePoint(LocalTime.of(16,9)));
        timeArr.add(new TimePoint(LocalTime.of(16,11)));
        timeArr.add(new TimePoint(LocalTime.of(16,13)));
        timeArr.add(new TimePoint(LocalTime.of(16,19)));
        timeArr.add(new TimePoint(LocalTime.of(16,20)));
        timeArr.add(new TimePoint(LocalTime.of(16,24)));
        timeArr.add(new TimePoint(LocalTime.of(16,25)));
        timeArr.add(new TimePoint(LocalTime.of(16,27)));
        timeArr.add(new TimePoint(LocalTime.of(16,29)));
        timeArr.add(new TimePoint(LocalTime.of(16,30)));
        timeArr.add(new TimePoint(LocalTime.of(16,31)));
        timeArr.add(new TimePoint(LocalTime.of(16,32)));
        timeArr.add(new TimePoint(LocalTime.of(16,33)));
        timeArr.add(new TimePoint(LocalTime.of(16,35)));


        Schedule schedule = new Schedule(false, false, "važiuoja darbo dienomis", BoundFor.OUT_BOUND, timeArr, route1);

        scheduleRepo.save(schedule);
    }
    private void newSchedule3_6(){
        Route route1 = new Route();
        route1.setId(5L);
        List<TimePoint> timeArr = new ArrayList<>();

        timeArr.add(new TimePoint(LocalTime.of(16,35)));
        timeArr.add(new TimePoint(LocalTime.of(16,37)));
        timeArr.add(new TimePoint(LocalTime.of(16,40)));
        timeArr.add(new TimePoint(LocalTime.of(16,41)));
        timeArr.add(new TimePoint(LocalTime.of(16,44)));
        timeArr.add(new TimePoint(LocalTime.of(16,46)));
        timeArr.add(new TimePoint(LocalTime.of(16,50)));
        timeArr.add(new TimePoint(LocalTime.of(16,53)));
        timeArr.add(new TimePoint(LocalTime.of(16,55)));
        timeArr.add(new TimePoint(LocalTime.of(17,0)));
        timeArr.add(new TimePoint(LocalTime.of(17,2)));
        timeArr.add(new TimePoint(LocalTime.of(17,5)));
        timeArr.add(new TimePoint(LocalTime.of(17,6)));
        timeArr.add(new TimePoint(LocalTime.of(17,7)));
        timeArr.add(new TimePoint(LocalTime.of(17,8)));
        timeArr.add(new TimePoint(LocalTime.of(17,9)));
        timeArr.add(new TimePoint(LocalTime.of(17,10)));


        Schedule schedule = new Schedule(true, false, "važiuoja darbo dienomis", BoundFor.CITY_BOUND, timeArr, route1);

        scheduleRepo.save(schedule);
    }
}
