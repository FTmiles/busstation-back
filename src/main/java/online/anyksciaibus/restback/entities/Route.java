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
}

