package online.anyksciaibus.restback.dto;

import jakarta.persistence.*;
import online.anyksciaibus.restback.entities.BoundFor;
import online.anyksciaibus.restback.entities.Route;
import online.anyksciaibus.restback.entities.Schedule;
import online.anyksciaibus.restback.entities.timeconstraints.RunsOnYearly;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

public class SchedulesDto {
    Long id;

    String customName;

    Boolean isRouteDirReversed;
    Boolean isWorkInProgress;
    String timeConstraintsDescription;

    BoundFor boundFor;  //used for filtering routes

    List<LocalTime> timeList;
    Route route;

    List<DayOfWeek> runsOnWeekly;   //which days of the week
    RunsOnYearly runsOnYearly;       //which periods like summer, schooldays,...
    boolean runsOnPublicHolidays; //true = runs on public holidays


    //==================

    public static SchedulesDto scheduleToDto(Schedule schedule){
        SchedulesDto dto = new SchedulesDto();
        dto.setBoundFor(schedule.getBoundFor());
        dto.setId(schedule.getId());

        dto.setRoute(schedule.getRoute());
        dto.getRoute().setDistanceMetersList(null);

        dto.setRouteDirReversed(schedule.getRouteDirReversed());
        dto.setTimeList(schedule.getTimeList());
        dto.setWorkInProgress(schedule.getWorkInProgress());
        dto.setTimeConstraintsDescription(schedule.getTimeConstraintsDescription());
        dto.setRunsOnWeekly(schedule.getRunsOnWeekly());
        dto.setRunsOnPublicHolidays(schedule.isRunsOnPublicHolidays());
        dto.setRunsOnYearly(schedule.getRunsOnYearly());

//        dto.customName =

        return null;
    }

    //==================
    public SchedulesDto() {
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

    public BoundFor getBoundFor() {
        return boundFor;
    }

    public void setBoundFor(BoundFor boundFor) {
        this.boundFor = boundFor;
    }

    public List<LocalTime> getTimeList() {
        return timeList;
    }

    public void setTimeList(List<LocalTime> timeList) {
        this.timeList = timeList;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
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
}

