package online.anyksciaibus.restback.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.DayOfWeek;
import java.util.List;

@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "route_busstops",
            joinColumns = @JoinColumn(name = "route_id"),
            inverseJoinColumns = @JoinColumn(name = "stop_id"))
    @OrderColumn(name = "stops_arr_order")
    List<BusStop> stopsArr;


    @ElementCollection
    @OrderColumn(name = "distanceMetersListOrder")
    List<Integer> distanceMetersList;


    @JsonIgnore
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "line_id")
    Line line; //1 line has many routes (variations)

    String routeNotes;

    //===================================================




    public Route() {
    }

    public Route(List<BusStop> stopsArr, List<Integer> distanceMetersList, Line line, String routeNotes) {
        this.stopsArr = stopsArr;
        this.distanceMetersList = distanceMetersList;
        this.line = line;
        this.routeNotes = routeNotes;
    }

    public String getRouteNotes() {
        return routeNotes;
    }

    public void setRouteNotes(String routeNotes) {
        this.routeNotes = routeNotes;
    }

    public List<Integer> getDistanceMetersList() {
        return distanceMetersList;
    }

    public void setDistanceMetersList(List<Integer> distanceMetersList) {
        this.distanceMetersList = distanceMetersList;
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



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Route{");
        sb.append("id=").append(id);
        sb.append(", stopsArr=").append(stopsArr.size());
//        sb.append(", distanceMetersArr=").append(distanceMetersArr.size());
        sb.append(", line=").append(line);
        sb.append('}');
        return sb.toString();
    }
}

