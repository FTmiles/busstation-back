package online.anyksciaibus.restback.entities;

import jakarta.persistence.*;

@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Enumerated(EnumType.ORDINAL)
    RouteDescr routeDescr;

    BusStop[] stopsArr;
}
