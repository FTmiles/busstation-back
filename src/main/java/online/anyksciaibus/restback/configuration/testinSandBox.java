package online.anyksciaibus.restback.configuration;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

public class testinSandBox {
    private Map<Integer, LocalDate> easterDateMap = new HashMap<>();


    public static void main(String[] args) {

        LocalDate date = LocalDate.parse("2028-08-31");
        System.out.println(isItNthXdayInMonth(date, DayOfWeek.WEDNESDAY,7));
    }

    public static boolean isItNthXdayInMonth(LocalDate date, DayOfWeek desiredXday, int desiredOccurrenceInMonth){
    //Xday = Monday, Tuesday, ...
        if (date.getDayOfWeek() != desiredXday) {
            return false;
        }

    //Find date, which is the first Xday in the month
        LocalDate firstXdayInMonth = date.withDayOfMonth(1);
        while(firstXdayInMonth.getDayOfWeek().ordinal() != desiredXday.ordinal()){
            firstXdayInMonth = firstXdayInMonth.plusDays(1);
        }

        int difference = date.getDayOfMonth() - firstXdayInMonth.getDayOfMonth();
        float occurence = difference / 7F;
        //occurence == 0  -> first Xday in the month
        //          == 1  -> second
        //          == 2  -> third
        //          == 3  -> fourth
        return occurence + 1 == (float) desiredOccurrenceInMonth;


    }

}
