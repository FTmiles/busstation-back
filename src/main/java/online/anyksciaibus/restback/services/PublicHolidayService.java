package online.anyksciaibus.restback.services;

import online.anyksciaibus.restback.entities.timeconstraints.PublicHoliday;
import online.anyksciaibus.restback.repositories.PublicHolidayRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PublicHolidayService {
    private List<PublicHoliday> publicHolidays;
    private Map<Integer, LocalDate> easterDateMap;

    PublicHolidayRepo repo;

    public PublicHolidayService(PublicHolidayRepo repo){
        this.repo = repo;
        this.publicHolidays = getAll();

        this.easterDateMap = new HashMap<>();
        populateEasterMap();
    }


    public List<PublicHoliday> getAll() {
        return repo.findAll();
    }

    public Optional<PublicHoliday> get1LineById(Long id) {
        return repo.findById(id);
    }

    public List<PublicHoliday> saveAll(List<PublicHoliday> lineList) {
        return repo.saveAll(lineList);
    }

    public PublicHoliday save1(PublicHoliday line) {
        return repo.save(line);
    }

    public void delete1byId(Long id) {
        repo.deleteById(id);
    }

    public void deleteMultiple(List<Long> ids) {
        repo.deleteAllById(ids);
    }


    public boolean isTheDayPublicHoliday(LocalDate date){
        int month = date.getMonthValue();
        int dayOfMonth = date.getDayOfMonth();

        for (PublicHoliday holiday : publicHolidays) {
            if (month == holiday.getMonth() && dayOfMonth == holiday.getDay())
                return true;
        }

        LocalDate easterDate = easterDateMap.get(date.getYear());
        if (easterDate == null)
            easterDate = calculateEasterDate(date.getYear());


        return date.isEqual(easterDate) ||
                date.isEqual(easterDate.plusDays(1));

    }

    public static LocalDate calculateEasterDate(int year) {
        int a = year % 19;
        int b = year / 100;
        int c = year % 100;
        int d = b / 4;
        int e = b % 4;
        int f = (b + 8) / 25;
        int g = (b - f + 1) / 3;
        int h = (19 * a + b - d - g + 15) % 30;
        int i = c / 4;
        int k = c % 4;
        int l = (32 + 2 * e + 2 * i - h - k) % 7;
        int m = (a + 11 * h + 22 * l) / 451;
        int month = (h + l - 7 * m + 114) / 31;
        int day = ((h + l - 7 * m + 114) % 31) + 1;
        return LocalDate.of(year, month, day);
    }

    public void populateEasterMap(){
        int thisYear = LocalDate.now().getYear();
        System.out.println("hello there");
        for (int i = thisYear-5; i < thisYear+30; i++) {
            easterDateMap.put(i, calculateEasterDate(i));
        }

    }

}
