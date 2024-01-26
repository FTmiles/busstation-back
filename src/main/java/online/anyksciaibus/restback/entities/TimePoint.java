package online.anyksciaibus.restback.entities;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
public class TimePoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    LocalTime time;








    //===========================================

    public TimePoint() {
    }

    public TimePoint(LocalTime time) {
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
