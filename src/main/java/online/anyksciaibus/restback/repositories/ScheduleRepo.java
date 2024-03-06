package online.anyksciaibus.restback.repositories;

import jakarta.transaction.Transactional;
import online.anyksciaibus.restback.entities.Route;
import online.anyksciaibus.restback.entities.Schedule;
import online.anyksciaibus.restback.entities.timeconstraints.RunsOnYearly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;

@Repository
public interface ScheduleRepo extends JpaRepository<Schedule, Long> {

    @Query("SELECT s FROM Schedule s " +
            "WHERE :dayOfWeek MEMBER OF s.runsOnWeekly " +
            "AND s.runsOnPublicHolidays = :isPublicHoliday " +
            "AND s.runsOnYearly IN :runsOnYearlyList")
    List<Schedule> findSchedulesByDayOfWeekAndPublicHolidayAndRunsOnYearly(DayOfWeek dayOfWeek, boolean isPublicHoliday, List<RunsOnYearly> runsOnYearlyList);

//    @Query("SELECT s FROM Schedule s " +
//            "WHERE UPPER(s.boundFor) = UPPER(:dayOfWeek) " +
//            "AND s.runsOnPublicHolidays = :isPublicHoliday " +
//            "AND s.runsOnYearly IN :runsOnYearlyList")
//    List<Schedule> findSchedulesByDayOfWeekAndPublicHolidayAndRunsOnYearlyList(DayOfWeek dayOfWeek, boolean isPublicHoliday, List<RunsOnYearly> runsOnYearlyList);

    //TODO this not working anymore, and not needed
//    void deleteByRoute(Route route);

//    List<Schedule> findByRoute_Line_Id(Long lineId);
    List<Schedule> findByLineId(Long lineId);


    @Transactional
    void deleteByTripsRoute(Route route);

//    List<Schedule> findByLine(Line line);
//    List<Schedule> findByRoute(Route route);

//    @Query("SELECT s.id FROM Schedule s WHERE s.route = :route")
//    List<Long> findScheduleIdsByRoute(Route route);

//    @Query("SELECT DISTINCT t.route.id FROM Schedule s JOIN s.trips t WHERE s.route = :route")
//    List<Long> findScheduleRouteIdsByRoute(Route route);

    @Query("SELECT DISTINCT s.id FROM Schedule s JOIN s.trips t WHERE t.route = :route")
    List<Long> findScheduleIdsByRoute(Route route);

    @Query("SELECT CONCAT(l.name, ' - ', l.routeStart, ' - ', l.routeEnd) FROM Line l WHERE l.id = :lineId")
    Optional<String> getLineTitleByLineId(Long lineId);
}
