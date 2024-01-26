package online.anyksciaibus.restback.entities;

import jakarta.persistence.*;

@Entity
public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String routeStart;
    String routeEnd;
    String via;
    String operator;
    String anykStationPlatform;
    String price;

    @Enumerated(EnumType.ORDINAL)
    RouteType routeType;

}
