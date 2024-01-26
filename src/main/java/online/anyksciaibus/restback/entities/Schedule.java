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

    @Enumerated(EnumType.ORDINAL)
    RouteDescr routeDescr;  //used for filtering routes

    //main var. Scheduled times @bus stops
    //arba nauja entity kurtis kuri tures ID ir LocalTime[], arba taip veiks
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "schedule_id")
    private List<TimePoint> timeArr;

    @ManyToOne
    @JoinColumn(name = "route_id")
    Route route;




    //============================================
    public Schedule() {
    }

    public Schedule(Boolean isRouteDirReversed, Boolean isWorkInProgress, String timeConstraintsDescription, RouteDescr routeDescr, List<TimePoint> timeArr, Route route) {
        this.isRouteDirReversed = isRouteDirReversed;
        this.isWorkInProgress = isWorkInProgress;
        this.timeConstraintsDescription = timeConstraintsDescription;
        this.routeDescr = routeDescr;
        this.timeArr = timeArr;
        this.route = route;
    }

    public RouteDescr getRouteDescr() {
        return routeDescr;
    }

    public void setRouteDescr(RouteDescr routeDescr) {
        this.routeDescr = routeDescr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getRouteDirReversed() {
        return isRouteDirReversed;
    }

    public void setRouteDirReversed(Boolean routeDirReversed) {
        isRouteDirReversed = routeDirReversed;
    }

    public Boolean getWorkInProgress() {
        return isWorkInProgress;
    }

    public void setWorkInProgress(Boolean workInProgress) {
        isWorkInProgress = workInProgress;
    }

    public String getTimeConstraintsDescription() {
        return timeConstraintsDescription;
    }

    public void setTimeConstraintsDescription(String timeConstraintsDescription) {
        this.timeConstraintsDescription = timeConstraintsDescription;
    }

    public List<TimePoint> getTimeArr() {
        return timeArr;
    }

    public void setTimeArr(List<TimePoint> timeArr) {
        this.timeArr = timeArr;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
