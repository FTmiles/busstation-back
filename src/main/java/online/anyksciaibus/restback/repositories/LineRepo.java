package online.anyksciaibus.restback.repositories;

import online.anyksciaibus.restback.entities.Line;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineRepo extends JpaRepository<Line, Long> {
}
