package online.anyksciaibus.restback.repositories.maybeDontNeed;

import online.anyksciaibus.restback.entities.TimePoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimePointRepo extends JpaRepository<TimePoint, Long> {
}
