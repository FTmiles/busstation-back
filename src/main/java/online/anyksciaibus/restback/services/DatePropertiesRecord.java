package online.anyksciaibus.restback.services;

import online.anyksciaibus.restback.entities.timeconstraints.RunsOnYearly;

import java.util.List;

public record DatePropertiesRecord(boolean isPublicHoliday, List<RunsOnYearly> runsOnYearlyList) {
}
