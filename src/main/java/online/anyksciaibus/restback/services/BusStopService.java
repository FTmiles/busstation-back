package online.anyksciaibus.restback.services;

import online.anyksciaibus.restback.dto.BusStopsDto;
import online.anyksciaibus.restback.dto.LineIdNameDto;
import online.anyksciaibus.restback.entities.BusStop;
import online.anyksciaibus.restback.entities.Line;
import online.anyksciaibus.restback.repositories.BusStopRepo;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusStopService {
    BusStopRepo busStopRepo;

    public BusStopService(BusStopRepo busStopRepo) {
        this.busStopRepo = busStopRepo;
    }

    public List<BusStop> getAll() {
        return busStopRepo.findAll();
    }

    public Optional<BusStop> get1BusStopById(Long id) {
        return busStopRepo.findById(id);
    }

    public List<BusStop> saveAll(List<BusStop> busStopList) {
        return busStopRepo.saveAll(busStopList);
    }

    public BusStop save1(BusStop busStop) {
        return busStopRepo.save(busStop);
    }

    public void delete1byId(Long id) {
    //Route holds List<BusStop> stopsArr, its elements hold bus stop FK
        if (!busStopRepo.existsRoutesForBusStop(id))
            busStopRepo.deleteById(id);
    }

    public void deleteMultiple(List<Long> ids) {
        busStopRepo.deleteAllById(ids);
    }

    //===========================
    public List<BusStopsDto> getSearchOptions(String str) {
        if (str.isEmpty())
            return busStopRepo.findByDefaultOptionTrue().stream().map(BusStop::mapToDto).toList();
        else if (str.length() <= 2)
            return busStopRepo.findTop10ByNameStartingWithIgnoreCase(str)
                    .stream().map(BusStop::mapToDto).toList();


        return busStopRepo.findTop10ByNameContainingIgnoreCase(str)
                .stream().map(BusStop::mapToDto).toList();
    }

    public List<BusStop> getBySearchName(String searchQuery){
        return busStopRepo.findByNameContaining(searchQuery);
    }

    public List<BusStopsDto> getAllDto(){
        return busStopRepo.findAllBusStops();
    }

    public List<LineIdNameDto> findLineIdNameDtoByBusStop(BusStop busStop) {
        return busStopRepo.findLineIdsAndNamesByBusStop(busStop);
    }
}
