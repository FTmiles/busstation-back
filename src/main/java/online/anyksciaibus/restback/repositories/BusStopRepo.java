package online.anyksciaibus.restback.repositories;

import online.anyksciaibus.restback.entities.BusStop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusStopRepo extends JpaRepository<BusStop, Long> {
    //when searchTerm == ""
    List<BusStop> findByDefaultOptionTrue();

    //used for searchTerm > 2,     Ordered by first - starts as search term, then alphabetically
    @Query("SELECT b FROM BusStop b WHERE LOWER(b.name) LIKE LOWER(concat('%', ?1, '%')) ORDER BY CASE WHEN LOWER(b.name) LIKE LOWER(concat(?1, '%')) THEN 0 ELSE 1 END, b.name")
    List<BusStop> findTop10ByNameContainingIgnoreCase(String searchTerm);

    //at the start of a word (not string), used when searchTerm.length < 3. Ordered by first - starts as search term, then alphabetically
    @Query("SELECT b FROM BusStop b WHERE (LOWER(b.name) LIKE LOWER(concat(?1, '%')) OR LOWER(b.name) LIKE LOWER(concat('% ', ?1, '%'))) ORDER BY CASE WHEN LOWER(b.name) LIKE LOWER(concat(?1, '%')) THEN 0 ELSE 1 END, b.name")
    List<BusStop> findTop10ByNameStartingWithIgnoreCase(String searchTerm);

    List<BusStop> findByNameContaining(String searchQuery);

}
