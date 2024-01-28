package online.anyksciaibus.restback.dto;

import online.anyksciaibus.restback.entities.BusStop;
import online.anyksciaibus.restback.entities.DistancePoint;

import java.util.List;

public class RouteDto {

    private Long id;
    String routeNotes;
    List<BusStop> stopsArr;
    List<DistancePoint> distanceMetersArr;
    Long lineId;

    // =====================================


    public RouteDto() {
    }

    public RouteDto(Long id, String routeNotes, List<BusStop> stopsArr, List<DistancePoint> distanceMetersArr, Long lineId) {
        this.id = id;
        this.routeNotes = routeNotes;
        this.stopsArr = stopsArr;
        this.distanceMetersArr = distanceMetersArr;
        this.lineId = lineId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getRouteNotes() {
        return routeNotes;
    }

    public void setRouteNotes(String routeNotes) {
        this.routeNotes = routeNotes;
    }

    public List<BusStop> getStopsArr() {
        return stopsArr;
    }

    public void setStopsArr(List<BusStop> stopsArr) {
        this.stopsArr = stopsArr;
    }

    public List<DistancePoint> getDistanceMetersArr() {
        return distanceMetersArr;
    }

    public void setDistanceMetersArr(List<DistancePoint> distanceMetersArr) {
        this.distanceMetersArr = distanceMetersArr;
    }

    public Long getLineId() {
        return lineId;
    }

    public void setLineId(Long lineId) {
        this.lineId = lineId;
    }
}