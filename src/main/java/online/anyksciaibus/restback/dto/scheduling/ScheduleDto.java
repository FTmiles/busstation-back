package online.anyksciaibus.restback.dto.scheduling;

import online.anyksciaibus.restback.entities.Schedule;
import online.anyksciaibus.restback.entities.timeconstraints.RunsOnYearly;

import java.time.DayOfWeek;
import java.util.Collections;
import java.util.List;

public class ScheduleDto {
    Long id;

    Boolean isWorkInProgress;

    List<Trip1WayIdDto> trips;

    String timeConstraintsDescription;
    List<DayOfWeek> runsOnWeekly;   //which days of the week
    RunsOnYearly runsOnYearly;       //which periods like summer, schooldays,...
    boolean runsOnPublicHolidays; //true = runs on public holidays

    //==================

    public static ScheduleDto scheduleToDto(Schedule schedule){
        ScheduleDto dto = new ScheduleDto();
        dto.setId(schedule.getId());
        dto.setWorkInProgress(schedule.getWorkInProgress());
        dto.setTimeConstraintsDescription(schedule.getTimeConstraintsDescription());
        dto.setRunsOnPublicHolidays(schedule.isRunsOnPublicHolidays());
        dto.setRunsOnYearly(schedule.getRunsOnYearly());

        if (schedule.getRunsOnWeekly() == null)
            dto.setRunsOnWeekly(Collections.emptyList());
        else
            dto.setRunsOnWeekly(schedule.getRunsOnWeekly());

        if (schedule.getTrips() == null)
            dto.setTrips(Collections.emptyList());
        else
            dto.setTrips(schedule.getTrips().stream().map(Trip1WayIdDto::tripToDto).toList());

        return dto;
    }

    //==================
    public ScheduleDto() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getWorkInProgress() {
        return isWorkInProgress;
    }

    public void setWorkInProgress(Boolean workInProgress) {
        isWorkInProgress = workInProgress;
    }

    public List<Trip1WayIdDto> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip1WayIdDto> trips) {
        this.trips = trips;
    }

    public String getTimeConstraintsDescription() {
        return timeConstraintsDescription;
    }

    public void setTimeConstraintsDescription(String timeConstraintsDescription) {
        this.timeConstraintsDescription = timeConstraintsDescription;
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

