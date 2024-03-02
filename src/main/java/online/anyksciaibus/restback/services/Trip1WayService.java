package online.anyksciaibus.restback.services;

import online.anyksciaibus.restback.entities.Line;
import online.anyksciaibus.restback.entities.Trip1Way;
import online.anyksciaibus.restback.repositories.Trip1WayRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Trip1WayService {

    Trip1WayRepo repo;

    public Trip1WayService(Trip1WayRepo repo){
        this.repo = repo;
    }

    public List<Trip1Way> getAll() {
        return repo.findAll();
    }

    public Optional<Trip1Way> get1Trip1WayById(Long id) {
        return repo.findById(id);
    }

    public List<Trip1Way> saveAll(List<Trip1Way> trip1WayList) {
        return repo.saveAll(trip1WayList);
    }
}
