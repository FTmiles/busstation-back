package online.anyksciaibus.restback.dto.scheduling;

import online.anyksciaibus.restback.entities.timeconstraints.RunsOnYearly;
import online.anyksciaibus.restback.entities.timeconstraints.TypeOfYearlyRule;

public class RunsOnYearlyOptionDto {
    Long id;
    String periodName;
    TypeOfYearlyRule typeOfYearlyRule;

    //-------------------
    public static RunsOnYearlyOptionDto RunsOnYearlyToDto (RunsOnYearly runsOnYearly) {
        RunsOnYearlyOptionDto dto = new RunsOnYearlyOptionDto();
        dto.setId(runsOnYearly.getId());
        dto.setPeriodName(runsOnYearly.getPeriodName());
        dto.setTypeOfYearlyRule(runsOnYearly.getTypeOfYearlyRule());

        return dto;
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
}
