package online.anyksciaibus.restback.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;



    @ManyToMany
    @JoinTable(
            name = "route_busstops",
            joinColumns = @JoinColumn(name = "route_id"),
            inverseJoinColumns = @JoinColumn(name = "stop_id"))
    @OrderColumn(name = "stops_arr_order")
    List<BusStop> stopsArr;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "route_id")
    @OrderColumn(name = "distanceMetersArrOrder")
    List<DistancePoint> distanceMetersArr;

    @ManyToOne
    @JoinColumn(name = "line_id")
    Line line; //1 line has many routes (variations)

    String routeNotes;



    //===================================================


    public Route() {
    }

    public Route(List<BusStop> stopsArr, List<DistancePoint> distanceMetersArr, Line line, String routeNotes) {
        this.stopsArr = stopsArr;
        this.distanceMetersArr = distanceMetersArr;
        this.line = line;
        this.routeNotes = routeNotes;
    }

    public String getRouteNotes() {
        return routeNotes;
    }

    public void setRouteNotes(String routeNotes) {
        this.routeNotes = routeNotes;
    }

    public List<DistancePoint> getDistanceMetersArr() {
        return distanceMetersArr;
    }

    public void setDistanceMetersArr(List<DistancePoint> distanceMetersArr) {
        this.distanceMetersArr = distanceMetersArr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<BusStop> getStopsArr() {
        return stopsArr;
    }

    public void setStopsArr(List<BusStop> stopsArr) {
        this.stopsArr = stopsArr;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }
}

