package online.anyksciaibus.restback.services;

import online.anyksciaibus.restback.entities.BusStop;
import online.anyksciaibus.restback.repositories.BusStopRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusStopService {
    BusStopRepo busStopRepo;

    public BusStopService(BusStopRepo busStopRepo){
        this.busStopRepo = busStopRepo;
    }

    public List<BusStop> getAll(){
        return busStopRepo.findAll();
    }

    public Optional<BusStop> get1BusStopById(Long id){
        return busStopRepo.findById(id);
    }

    public List<BusStop> saveAll(List<BusStop> busStopList){
        return busStopRepo.saveAll(busStopList);
    }

    public BusStop save1(BusStop busStop){
        return busStopRepo.save(busStop);
    }

    public void delete1byId(Long id){
        busStopRepo.deleteById(id);
    }
    public void deleteMultiple(List<Long> ids){
        busStopRepo.deleteAllById(ids);
    }

}
