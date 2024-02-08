package online.anyksciaibus.restback.dto;

import online.anyksciaibus.restback.entities.Line;
import online.anyksciaibus.restback.entities.Route;

import java.util.ArrayList;
import java.util.List;

public class LineEagerDto {
    List<KeyValueDto> info;
    List<Route> routes;
    String name;





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

        return new LineEagerDto(info, line.getRoutes(), line.getName());
    }


    //=================================

    public LineEagerDto() {
    }

    public LineEagerDto(List<KeyValueDto> info, List<Route> routes, String name) {
        this.info = info;
        this.routes = routes;
        this.name = name;
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
}
