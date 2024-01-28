package online.anyksciaibus.restback.dto;

import java.time.LocalTime;


public class SchedItemHomeDto {
    Long id;
    String timeDepart;
    String destination;
    String lineName;
    Boolean isTooLate;









    //=========================================================

    public SchedItemHomeDto() {
    }

    public SchedItemHomeDto(Long id, String timeDepart, String destination, String lineName, Boolean isTooLate) {
        this.id = id;
        this.timeDepart = timeDepart;
        this.destination = destination;
        this.lineName = lineName;
        this.isTooLate = isTooLate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTimeDepart() {
        return timeDepart;
    }

    public void setTimeDepart(String timeDepart) {
        this.timeDepart = timeDepart;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public Boolean getTooLate() {
        return isTooLate;
    }

    public void setTooLate(Boolean tooLate) {
        isTooLate = tooLate;
    }
}
