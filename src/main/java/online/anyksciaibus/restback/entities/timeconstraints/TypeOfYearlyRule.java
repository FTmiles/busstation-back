package online.anyksciaibus.restback.entities.timeconstraints;

public enum TypeOfYearlyRule {
    //check if the date is within the Fixed Time Period
    FIXED_TIME_PERIOD,

    //check if the date passes the method - pattern #1
    DYNAMIC_PATTERN1_EACH_XDAY_OF_MONTH
}
