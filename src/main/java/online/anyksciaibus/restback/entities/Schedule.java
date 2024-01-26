package online.anyksciaibus.restback.entities;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.List;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Boolean isRouteDirReversed;
    Boolean isWorkInProgress;
    String timeConstraintsDescription;

    //main var. Scheduled times @bus stops
    //arba nauja entity kurtis kuri tures ID ir LocalTime[], arba taip veiks
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "schedule_id")
    private List<TimePoint> timeArr;

    @ManyToOne
    @JoinColumn(name = "route_id")
    Route route;


}
