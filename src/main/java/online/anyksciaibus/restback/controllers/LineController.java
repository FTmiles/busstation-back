package online.anyksciaibus.restback.controllers;

import online.anyksciaibus.restback.entities.Line;

import online.anyksciaibus.restback.services.LineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/line")
@CrossOrigin
public class LineController {


    LineService service;

    public LineController(LineService service) {
        this.service = service;
    }


    @GetMapping("/get/all")
    public List<Line> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Line> getOne(@PathVariable Long id) {
        Optional<Line> data = service.get1LineById(id);
        if (data.isPresent())
            return ResponseEntity.ok(data.get());
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("/save/multi")
    public List<Line> saveMulti(@RequestBody List<Line> list) {
        return service.saveAll(list);
    }

    @PostMapping("/save/one")
    public Line saveOne(@RequestBody Line line) {
        return service.save1(line);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOne(@PathVariable Long id) {
        service.delete1byId(id);
    }


    @DeleteMapping("/delete/multi")
    public void deleteMulti(@RequestBody List<Long> ids) {
        service.deleteMultiple(ids);
    }

    //UPSERT
    @PutMapping("/put/{id}")
    public ResponseEntity<Void> putOne(@PathVariable Long id, @RequestBody Line updatedLine) {

        Optional<Line> existingLineOptional = service.get1LineById(id);
        if (existingLineOptional.isEmpty() || !id.equals(updatedLine.getId()))
            return ResponseEntity.badRequest().build();

        service.save1(updatedLine);
        return ResponseEntity.noContent().build();
    }


}
