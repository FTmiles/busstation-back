package online.anyksciaibus.restback.repositories;

import online.anyksciaibus.restback.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepo extends JpaRepository<Route, Long> {
}
