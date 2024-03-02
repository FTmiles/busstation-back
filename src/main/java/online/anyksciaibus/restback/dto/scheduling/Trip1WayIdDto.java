package online.anyksciaibus.restback.dto.scheduling;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import jakarta.persistence.*;
import online.anyksciaibus.restback.entities.BoundFor;
import online.anyksciaibus.restback.entities.Route;
import online.anyksciaibus.restback.entities.Trip1Way;

import java.time.LocalTime;
import java.util.List;

public class Trip1WayIdDto {
    Long id;

    Boolean isRouteDirReversed;
    BoundFor boundFor;  //used for filtering routes
    List<LocalTime> timeList;

//    @JsonIdentityReference(alwaysAsId=true)
    Long routeId;

    //===================

    public static Trip1WayIdDto tripToDto(Trip1Way trip1way){
        Trip1WayIdDto dto = new Trip1WayIdDto();
        dto.setBoundFor(trip1way.getBoundFor());
        dto.setId(trip1way.getId());
        dto.setRouteId(trip1way.getRoute().getId());
        dto.setRouteDirReversed(trip1way.getRouteDirReversed());
        dto.setTimeList(trip1way.getTimeList());
        return dto;
    }

    //===================


    public Trip1WayIdDto() {
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

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }


}
