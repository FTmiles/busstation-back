package online.anyksciaibus.restback.dto;

import online.anyksciaibus.restback.entities.Line;
import online.anyksciaibus.restback.entities.Route;
import online.anyksciaibus.restback.entities.RouteType;
import online.anyksciaibus.restback.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineFullDto {
    LineInfo info;
    List<Route> routes;
    List<RouteType> routeTypeOptions;
    List<List<Long>> routeUsage;
    //------------------------------------
    public static LineFullDto lineToDto (Line line){
        LineInfo info = new LineInfo();
        info.setId(line.getId());
        info.setOperator(line.getOperator());
        info.setAnykStationPlatform(line.getAnykStationPlatform());
        info.setPrice(line.getPrice());
        info.setName(line.getName());
        info.setRouteType(line.getRouteType());
        info.setRouteStart(line.getRouteStart());
        info.setRouteEnd(line.getRouteEnd());
        info.setVia(line.getVia());

        List<Route> routes = line.getRoutes() != null ? line.getRoutes() : Collections.emptyList();

        return new LineFullDto(info, routes, List.of(RouteType.values()));
    }


    public static Line dtoToLine (LineFullDto dto) {
        Line line = new Line();
        LineInfo info = dto.getInfo();
        line.setId(info.getId());
        line.setVia(info.via);
        line.setRouteType(info.getRouteType());
        line.setPrice(info.getPrice());
        line.setOperator(info.getOperator());
        line.setName(info.getName());
        line.setRouteEnd(info.getRouteEnd());
        line.setRouteStart(info.getRouteStart());
        line.setAnykStationPlatform(info.anykStationPlatform);

        //add Line, it was ignored for JSON
        List<Route> routes = dto.getRoutes().stream().map(route -> {
            route.setLine(line);
            return route;
        }).toList();
        line.setRoutes( routes );

        return line;
    }

    //=============================


    public LineFullDto() {
    }

    public LineFullDto(LineInfo info, List<Route> routes, List<RouteType> routeTypeOptions) {
        this.info = info;
        this.routes = routes;
        this.routeTypeOptions = routeTypeOptions;
    }

    public LineInfo getInfo() {
        return info;
    }

    public void setInfo(LineInfo info) {
        this.info = info;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public List<List<Long>> getRouteUsage() {
        return routeUsage;
    }

    public void setRouteUsage(List<List<Long>> routeUsage) {
        this.routeUsage = routeUsage;
    }

    public List<RouteType> getRouteTypeOptions() {
        return routeTypeOptions;
    }

    public void setRouteTypeOptions(List<RouteType> routeTypeOptions) {
        this.routeTypeOptions = routeTypeOptions;
    }
}
