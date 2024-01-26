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

    @ManyToOne
    @JoinColumn(name = "line_id")
    Line line; //1 line has many routes (variations)




    //===================================================


    public Route() {
    }

    public Route(List<BusStop> stopsArr, Line line) {
        this.stopsArr = stopsArr;
        this.line = line;
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

