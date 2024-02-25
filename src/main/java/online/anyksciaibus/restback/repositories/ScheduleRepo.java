package online.anyksciaibus.restback.repositories;

import online.anyksciaibus.restback.entities.Route;
import online.anyksciaibus.restback.entities.Schedule;
import online.anyksciaibus.restback.entities.timeconstraints.RunsOnYearly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

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

    void deleteByRoute(Route route);

    List<Schedule> findByRoute_Line_Id(Long lineId);


}
