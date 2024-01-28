package online.anyksciaibus.restback.services;

import online.anyksciaibus.restback.dto.RouteDto;
import online.anyksciaibus.restback.entities.BusStop;
import online.anyksciaibus.restback.entities.DistancePoint;
import online.anyksciaibus.restback.entities.Route;
import online.anyksciaibus.restback.repositories.RouteRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RouteService {

    RouteRepo routeRepo;

    public RouteService(RouteRepo routeRepo){
        this.routeRepo = routeRepo;
    }

    public List<Route> getAll() {
        return routeRepo.findAll();
    }

    public Optional<Route> get1RouteById(Long id) {
        return routeRepo.findById(id);
    }

    public List<Route> saveAll(List<Route> routeList) {
        return routeRepo.saveAll(routeList);
    }

    public Route save1(Route route) {
        return routeRepo.save(route);
    }

    public void delete1byId(Long id) {
        routeRepo.deleteById(id);
    }

    public void deleteMultiple(List<Long> ids) {
        routeRepo.deleteAllById(ids);
    }



    //==========================

    public List<RouteDto> getRoutesByLineId(Long lineId) {
        List<Route> routes = routeRepo.findByLineId(lineId);
        List<RouteDto> routeDtos = new ArrayList<>();

        for (Route route : routes) {
            RouteDto routeDto = new RouteDto();
            routeDto.setId(route.getId());
            routeDto.setRouteNotes(route.getRouteNotes());
            routeDto.setLineId(lineId);
            routeDto.setStopsArr(route.getStopsArr());
            routeDto.setDistanceMetersArr(route.getDistanceMetersArr());

            routeDtos.add(routeDto);
        }

        return routeDtos;
    }

}
