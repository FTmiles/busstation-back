package online.anyksciaibus.restback.entities;

import jakarta.persistence.*;

@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Enumerated(EnumType.ORDINAL)
    RouteDescr routeDescr;  //used for filtering routes

    @ManyToMany
    @JoinTable(name = "route_busstops",
            joinColumns = @JoinColumn(name = "route_id"),
            inverseJoinColumns = @JoinColumn(name = "stop_id"))
    BusStop[] stopsArr;

    @ManyToOne
    @JoinColumn(name = "line_id")
    Line line; //1 line has many routes (variations)




    //===================================================


    public Route() {
    }

    public Route(RouteDescr routeDescr, BusStop[] stopsArr, Line line) {
        this.routeDescr = routeDescr;
        this.stopsArr = stopsArr;
        this.line = line;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RouteDescr getRouteDescr() {
        return routeDescr;
    }

    public void setRouteDescr(RouteDescr routeDescr) {
        this.routeDescr = routeDescr;
    }

    public BusStop[] getStopsArr() {
        return stopsArr;
    }

    public void setStopsArr(BusStop[] stopsArr) {
        this.stopsArr = stopsArr;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }
}

