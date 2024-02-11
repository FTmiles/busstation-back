package online.anyksciaibus.restback.controllers;

import online.anyksciaibus.restback.dto.BusStopsDto;
import online.anyksciaibus.restback.entities.BusStop;
import online.anyksciaibus.restback.services.BusStopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/busstop")
@CrossOrigin
public class BusStopController {
    BusStopService service;

    public BusStopController(BusStopService service) {
        this.service = service;
    }


    @GetMapping("/get/all")
    public List<BusStop> getAll() {
        return service.getAll();
    }



    @GetMapping("/get/{id}")
    public ResponseEntity<BusStop> getOne(@PathVariable Long id) {
        Optional<BusStop> data = service.get1BusStopById(id);
        if (data.isPresent())
            return ResponseEntity.ok(data.get());
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("/save/multi")
    public List<BusStop> saveMulti(@RequestBody List<BusStop> list) {
        return service.saveAll(list);
    }

    @PostMapping("/save/one")
    public BusStop saveOne(@RequestBody BusStop busStop) {
        System.out.println(busStop);
        return service.save1(busStop);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOne (@PathVariable Long id){
        service.delete1byId(id);
    }


    @DeleteMapping("/delete/multi")
    public void deleteMulti(@RequestBody List<Long> ids){
        service.deleteMultiple(ids);
    }

    //replace or insert if not found
    @PutMapping ("/put/{id}")
    public ResponseEntity<Void> putOne(@PathVariable Long id, @RequestBody BusStop updatedBusStop){

        Optional<BusStop> existingBusStopOptional = service.get1BusStopById(id);
        if (existingBusStopOptional.isEmpty() || !id.equals(updatedBusStop.getId()))
            return ResponseEntity.badRequest().build();

        service.save1(updatedBusStop);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/put/updateAll")
    public ResponseEntity<Void> updateAllBusStops(@RequestBody List<BusStop> updatedBusStops) {
        // Check if all IDs in the list exist
        for (BusStop updatedBusStop : updatedBusStops) {
            Long id = updatedBusStop.getId();
            Optional<BusStop> existingBusStopOptional = service.get1BusStopById(id);

            if (existingBusStopOptional.isEmpty()) {
                // Resource with given ID not found, return 404 Not Found
                return ResponseEntity.notFound().build();
            }
        }

        // If all IDs exist, perform updates
        for (BusStop updatedBusStop : updatedBusStops) {
            // Update the existing bus stop with the new data
            service.save1(updatedBusStop);
        }

        return ResponseEntity.noContent().build(); // Return 204 No Content for successful update
    }

    @GetMapping("/searchresults")
    public List<BusStop> getSearchByName(@RequestParam String query){
        return service.getBySearchName(query);
    }


//============?
    @GetMapping("/search")
    public List<BusStopsDto> getinit(@RequestParam String str) {
        return service.getSearchOptions(str);
    }

    @GetMapping("/alldto")
    public List<BusStopsDto> getAllDto(){
        return service.getAllDto();
    }
}
