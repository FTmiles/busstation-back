package online.anyksciaibus.restback.services.timeconstraints;


import online.anyksciaibus.restback.entities.timeconstraints.RunsOnYearly;
import online.anyksciaibus.restback.entities.timeconstraints.TimePeriod;
import online.anyksciaibus.restback.entities.timeconstraints.TypeOfYearlyRule;
import online.anyksciaibus.restback.repositories.RunsOnYearlyRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RunsOnYearlyService {
    RunsOnYearlyRepo repo;
    List<RunsOnYearly> allYearlyRules = new ArrayList<>();


    public RunsOnYearlyService(RunsOnYearlyRepo repo){
        this.repo = repo;
        allYearlyRules = getAll();
    }

    public List<RunsOnYearly> getAll() {
        return repo.findAll();
    }

    public Optional<RunsOnYearly> get1RunsOnYearlyById(Long id) {
        return repo.findById(id);
    }

    public List<RunsOnYearly> saveAll(List<RunsOnYearly> runsOnYearlyList) {
        return repo.saveAll(runsOnYearlyList);
    }

    public RunsOnYearly save1(RunsOnYearly runsOnYearly) {
        return repo.save(runsOnYearly);
    }

    public void delete1byId(Long id) {
        repo.deleteById(id);
    }

    public void deleteMultiple(List<Long> ids) {
        repo.deleteAllById(ids);
    }

    public List<RunsOnYearly> passingYearlyRulesByDate(LocalDate date){
        return allYearlyRules.stream().filter(rule->{
            if (rule.getTypeOfYearlyRule().equals(TypeOfYearlyRule.FIXED_TIME_PERIOD)){
                for (TimePeriod d : rule.getTimePeriods()) {
                    LocalDate start = LocalDate.of(date.getYear(),d.getStartMonth(), d.getStartDay());
                    LocalDate end = LocalDate.of(date.getYear(),d.getEndMonth(), d.getEndDay());
                    if( (date.isAfter(start) || date.isEqual(start))&&
                            (date.isBefore(end)) || date.isEqual(end))
                        return true;
                }
                return false;
            }
            else if (rule.getTypeOfYearlyRule().equals(TypeOfYearlyRule.DYNAMIC_PATTERN1_EACH_XDAY_OF_MONTH)){
                return rule.testPattern1(date);
            }
            return false;
        })

//                .map(RunsOnYearly::getId)
                .toList();

    }
}
