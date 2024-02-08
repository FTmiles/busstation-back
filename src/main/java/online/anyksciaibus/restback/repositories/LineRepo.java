package online.anyksciaibus.restback.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import online.anyksciaibus.restback.entities.Line;
import online.anyksciaibus.restback.entities.Route;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineRepo extends JpaRepository<Line, Long> {

}

