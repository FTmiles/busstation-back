package online.anyksciaibus.restback.repositories;

import online.anyksciaibus.restback.entities.BusStop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusStopRepo extends JpaRepository<BusStop, Long> {
}
