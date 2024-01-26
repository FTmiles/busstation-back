package online.anyksciaibus.restback.entities;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
public class TimePoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    LocalTime time;


}
