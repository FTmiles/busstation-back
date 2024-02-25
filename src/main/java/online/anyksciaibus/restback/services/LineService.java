package online.anyksciaibus.restback.services;

import jakarta.transaction.Transactional;
import online.anyksciaibus.restback.dto.LinePreviewDto;
import online.anyksciaibus.restback.entities.BusStop;
import online.anyksciaibus.restback.entities.Line;


import online.anyksciaibus.restback.entities.Route;
import online.anyksciaibus.restback.entities.Schedule;
import online.anyksciaibus.restback.repositories.BusStopRepo;
import online.anyksciaibus.restback.repositories.LineRepo;
import online.anyksciaibus.restback.repositories.RouteRepo;
import online.anyksciaibus.restback.repositories.ScheduleRepo;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class LineService {

    LineRepo lineRepo;
    BusStopRepo busStopRepo;
    RouteRepo routeRepo;
    ScheduleRepo scheduleRepo;

    public LineService(LineRepo lineRepo, BusStopRepo busStopRepo, RouteRepo routeRepo, ScheduleRepo scheduleRepo) {
        this.busStopRepo = busStopRepo;
        this.lineRepo = lineRepo;
        this.routeRepo = routeRepo;
        this.scheduleRepo = scheduleRepo;
    }


    public List<Line> getAll() {
        return lineRepo.findAll();
    }

    public Optional<Line> get1LineById(Long id) {
        return lineRepo.findById(id);
    }

    public List<Line> saveAll(List<Line> lineList) {
        return lineRepo.saveAll(lineList);
    }


    public Line save1(Line line) {
//        for (Route route : line.getRoutes()) {
//            for (BusStop busStop : route.getStopsArr()) {
//                if (busStop.getId() < 0) { // Assuming negative IDs indicate new entities
//                    // Persist the BusStop to the database to get a new ID
//                    BusStop persistedBusStop = busStopRepo.save(busStop);
//                    // Update the BusStop object with the new ID
//                    busStop.setId(persistedBusStop.getId());
//                }
//            }
//        }

        //if id negative, assign null; negative id assigned at front end means new entry
        for (Route route : line.getRoutes()) {
            if (route.getId()<0) route.setId(null);
        }

        return lineRepo.save(line);
    }

    @Transactional
    public void delete1byId(Long id) {

        List<Route> routes = routeRepo.findByLineId(id);
        System.out.println(routes);
        for (Route route : routes) {
            scheduleRepo.deleteByRoute(route);
        }


        lineRepo.deleteById(id);
    }

    public void deleteMultiple(List<Long> ids) {
        lineRepo.deleteAllById(ids);
    }

    //================

    public LinePreviewDto getLinePreviewDto(Long id) {
        Optional<Line> optionalLine = lineRepo.findById(id);
        if (optionalLine.isEmpty()) {
            return new LinePreviewDto();
    }
        Line line = optionalLine.get();
        return LinePreviewDto.convertToLinePreviewDto(line);
    }

    public Optional<Line> myLineById(Long id) {
        return lineRepo.findById(id);
    }
}
