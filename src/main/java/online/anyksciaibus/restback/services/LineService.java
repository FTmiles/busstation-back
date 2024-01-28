package online.anyksciaibus.restback.services;

import online.anyksciaibus.restback.entities.Line;


import online.anyksciaibus.restback.repositories.LineRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LineService {

    LineRepo lineRepo;

    public LineService(LineRepo lineRepo) {
        this.lineRepo = lineRepo;
    }


    public List<Line> getAll() {
        System.out.println(lineRepo.findAll());
        return lineRepo.findAll();
    }

    public Optional<Line> get1LineById(Long id) {
        return lineRepo.findById(id);
    }

    public List<Line> saveAll(List<Line> lineList) {
        return lineRepo.saveAll(lineList);
    }

    public Line save1(Line line) {
        return lineRepo.save(line);
    }

    public void delete1byId(Long id) {
        lineRepo.deleteById(id);
    }

    public void deleteMultiple(List<Long> ids) {
        lineRepo.deleteAllById(ids);
    }

}
