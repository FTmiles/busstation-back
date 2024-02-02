package online.anyksciaibus.restback.entities;

import jakarta.persistence.*;
import online.anyksciaibus.restback.entities.timeconstraints.RunsOnYearly;

import java.time.DayOfWeek;
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
    BoundFor boundFor;  //used for filtering routes

    //main var. Scheduled times @bus stops
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "schedule_id")
    @OrderColumn(name = "timeArrOrder")
    private List<TimePoint> timeArr;

    @ManyToOne
    @JoinColumn(name = "route_id")
    Route route;

    //availability time constraints
    @ElementCollection
    @CollectionTable(name = "runsOnWeekly") // Specify the name of the collection table
    @Enumerated(EnumType.STRING)
    List<DayOfWeek> runsOnWeekly;   //which days of the week

    @ManyToOne
    RunsOnYearly runsOnYearly;       //which periods like summer, schooldays,...

    boolean runsOnPublicHolidays; //true = runs on public holidays

    //============================================
    public Schedule() {
    }

    public Schedule(Boolean isRouteDirReversed, Boolean isWorkInProgress, String timeConstraintsDescription, BoundFor boundFor, List<TimePoint> timeArr, Route route) {
        this.isRouteDirReversed = isRouteDirReversed;
        this.isWorkInProgress = isWorkInProgress;
        this.timeConstraintsDescription = timeConstraintsDescription;
        this.boundFor = boundFor;
        this.timeArr = timeArr;
        this.route = route;
    }

    public List<DayOfWeek> getRunsOnWeekly() {
        return runsOnWeekly;
    }

    public void setRunsOnWeekly(List<DayOfWeek> runsOnWeekly) {
        this.runsOnWeekly = runsOnWeekly;
    }

    public RunsOnYearly getRunsOnYearly() {
        return runsOnYearly;
    }

    public void setRunsOnYearly(RunsOnYearly runsOnYearly) {
        this.runsOnYearly = runsOnYearly;
    }

    public boolean isRunsOnPublicHolidays() {
        return runsOnPublicHolidays;
    }

    public void setRunsOnPublicHolidays(boolean runsOnPublicHolidays) {
        this.runsOnPublicHolidays = runsOnPublicHolidays;
    }

    public BoundFor getBoundFor() {
        return boundFor;
    }

    public void setBoundFor(BoundFor boundFor) {
        this.boundFor = boundFor;
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
