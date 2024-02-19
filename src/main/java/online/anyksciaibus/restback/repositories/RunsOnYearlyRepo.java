package online.anyksciaibus.restback.repositories;

import online.anyksciaibus.restback.entities.timeconstraints.RunsOnYearly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RunsOnYearlyRepo extends JpaRepository<RunsOnYearly, Long> {

}