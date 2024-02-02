package online.anyksciaibus.restback.repositories;

import online.anyksciaibus.restback.entities.timeconstraints.PublicHoliday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicHolidayRepo extends JpaRepository<PublicHoliday, Long> {
}
