package online.anyksciaibus.restback.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String routeStart;  //which city, not which station
    String routeEnd;    //which city, not which station
    String via;
    String operator;    //bus company
    String anykStationPlatform;
    String price;

    @Enumerated(EnumType.ORDINAL)
    RouteType routeType;

    @OneToMany(mappedBy = "line")
    List<Route> route;



    // =====================================================


    public Line() {
    }

    public Line(String name, String routeStart, String routeEnd, String via, String operator, String anykStationPlatform, String price, RouteType routeType, List<Route> route) {
        this.name = name;
        this.routeStart = routeStart;
        this.routeEnd = routeEnd;
        this.via = via;
        this.operator = operator;
        this.anykStationPlatform = anykStationPlatform;
        this.price = price;
        this.routeType = routeType;
        this.route = route;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRouteStart() {
        return routeStart;
    }

    public void setRouteStart(String routeStart) {
        this.routeStart = routeStart;
    }

    public String getRouteEnd() {
        return routeEnd;
    }

    public void setRouteEnd(String routeEnd) {
        this.routeEnd = routeEnd;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getAnykStationPlatform() {
        return anykStationPlatform;
    }

    public void setAnykStationPlatform(String anykStationPlatform) {
        this.anykStationPlatform = anykStationPlatform;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public RouteType getRouteType() {
        return routeType;
    }

    public void setRouteType(RouteType routeType) {
        this.routeType = routeType;
    }

    public List<Route> getRoute() {
        return route;
    }

    public void setRoute(List<Route> route) {
        this.route = route;
    }
}
