package online.anyksciaibus.restback.dto;

import online.anyksciaibus.restback.entities.BusStop;
import online.anyksciaibus.restback.entities.Line;
import online.anyksciaibus.restback.entities.Route;
import online.anyksciaibus.restback.entities.RouteType;

import java.util.ArrayList;
import java.util.List;

public class LineEagerDto {
    List<KeyValueDto> info;
    List<Route> routes;
    String name;
    Long id;





    public static LineEagerDto lineToDto (Line line){
        List<KeyValueDto> info = new ArrayList<>();
        info.add( new KeyValueDto("Line",  line.getName()  ));
        info.add( new KeyValueDto("From",  line.getRouteStart()  ));
        info.add( new KeyValueDto("To",  line.getRouteEnd()  ));
        info.add( new KeyValueDto("Via",  line.getVia()  ));
        info.add( new KeyValueDto("Operator",  line.getOperator()  ));
        info.add( new KeyValueDto("Route type",  line.getRouteType().getDescription()  ));
        info.add( new KeyValueDto("Anyksciu AS platform",  line.getAnykStationPlatform()  ));
        info.add( new KeyValueDto("Price",  line.getPrice()  ));

        return new LineEagerDto(info, line.getRoutes(), line.getName(), line.getId());
    }


    public static Line dtoToLine (LineEagerDto dto) {
        Line line = new Line();
        for (KeyValueDto info : dto.getInfo()) {
            switch (info.getKey()) {
                case "Line" -> line.setName(info.getValue());
                case "Operator" -> line.setOperator(info.getValue());
                case "Price" -> line.setPrice(info.getValue());
                case "Anyksciu AS platform" -> line.setAnykStationPlatform(info.getValue());
                case "From" -> line.setRouteStart(info.getValue());
                case "To" -> line.setRouteEnd(info.getValue());
                case "Via" -> line.setVia(info.getValue());
                case "Route type" -> line.setRouteType(RouteType.getByDescription(info.getValue()));
            }
        }
        line.setId(dto.getId());

        //add Line, it was ignored for JSON
        List<Route> routes = dto.getRoutes().stream().map(route -> {
            route.setLine(line);
            return route;
        }).toList();
        line.setRoutes( routes );

        return line;
    }

    //=================================

    public LineEagerDto() {
    }

    public LineEagerDto(List<KeyValueDto> info, List<Route> routes, String name, Long id) {
        this.info = info;
        this.routes = routes;
        this.name = name;
        this.id = id;
    }

    public List<KeyValueDto> getInfo() {
        return info;
    }

    public void setInfo(List<KeyValueDto> info) {
        this.info = info;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
