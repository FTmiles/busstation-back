package online.anyksciaibus.restback.entities.timeconstraints;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class RunsOnYearly {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String periodName;

    //FIXED_TIME_PERIOD                   -> check timePeriods if the date within the fixed dates
    //DYNAMIC_PATTERN1_EACH_XDAY_OF_MONTH -> check if pattern1 method passes with the given params
    TypeOfYearlyRule typeOfYearlyRule;

    //FIXED_TIME_PERIOD
    @OneToMany//(cascade = CascadeType.ALL)
    List<TimePeriod> timePeriods;

    //DYNAMIC_PATTERN1_EACH_XDAY_OF_MONTH
    @OneToMany//(cascade = CascadeType.ALL)
    List<Pattern1Params> pattern1Params;



    //pattern 1 - Every Nth Xday Each Month (e.g. every second Thursday each month)
    public boolean testPattern1(LocalDate date) {
        if (this.pattern1Params.isEmpty()) return false;

        for (Pattern1Params param : this.pattern1Params) {

            //Xday = Monday, Tuesday, ...
            if (date.getDayOfWeek() != param.desiredXday) {
                continue;
            }

            //Find date, which is the first Xday in the month
            LocalDate firstXdayInMonth = date.withDayOfMonth(1);
            while (firstXdayInMonth.getDayOfWeek().ordinal() != param.desiredXday.ordinal()) {
                firstXdayInMonth = firstXdayInMonth.plusDays(1);
            }

            int difference = date.getDayOfMonth() - firstXdayInMonth.getDayOfMonth();
            float occurence = difference / 7F;
            //occurence == 0  -> first Xday in the month
            //          == 1  -> second
            //          == 2  -> third
            //          == 3  -> fourth
            if (occurence + 1 == (float) param.nthOccurenceEachMonth )
                return true;
        }


        return false;
    }


    //=============================================


    public RunsOnYearly() {
    }

    public RunsOnYearly(String periodName, TypeOfYearlyRule typeOfYearlyRule, List<TimePeriod> timePeriods, List<Pattern1Params> pattern1Params) {
        this.periodName = periodName;
        this.typeOfYearlyRule = typeOfYearlyRule;
        this.timePeriods = timePeriods;
        this.pattern1Params = pattern1Params;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPeriodName() {
        return periodName;
    }

    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }

    public TypeOfYearlyRule getTypeOfYearlyRule() {
        return typeOfYearlyRule;
    }

    public void setTypeOfYearlyRule(TypeOfYearlyRule typeOfYearlyRule) {
        this.typeOfYearlyRule = typeOfYearlyRule;
    }

    public List<TimePeriod> getTimePeriods() {
        return timePeriods;
    }

    public void setTimePeriods(List<TimePeriod> timePeriods) {
        this.timePeriods = timePeriods;
    }

    public List<Pattern1Params> getPattern1Params() {
        return pattern1Params;
    }

    public void setPattern1Params(List<Pattern1Params> pattern1Params) {
        this.pattern1Params = pattern1Params;
    }
}

