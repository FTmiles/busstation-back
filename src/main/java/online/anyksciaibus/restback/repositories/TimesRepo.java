package online.anyksciaibus.restback.repositories;

import online.anyksciaibus.restback.entities.Times;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimesRepo extends JpaRepository<Times, Long> {
}
