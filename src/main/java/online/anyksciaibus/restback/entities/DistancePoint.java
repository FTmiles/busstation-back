package online.anyksciaibus.restback.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DistancePoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    int distanceMeters;




    //========================================

    public DistancePoint() {
    }

    public DistancePoint(int distanceMeters) {
        this.distanceMeters = distanceMeters;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDistanceMeters() {
        return distanceMeters;
    }

    public void setDistanceMeters(int distanceMeters) {
        this.distanceMeters = distanceMeters;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DistancePoint{");
        sb.append("id=").append(id);
        sb.append(", distanceMeters=").append(distanceMeters);
        sb.append('}');
        return sb.toString();
    }
}
