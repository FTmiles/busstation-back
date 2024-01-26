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
}
