package com.example.project.Controllers;

import com.example.project.Models.LastStationModel;
import com.example.project.Services.LastStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lastStation")
public class LastStationController {
    private final LastStationService lastStationService;

    @Autowired
    public LastStationController(LastStationService lastStationService){
        this.lastStationService = lastStationService;
    }
    //GET------>
    @GetMapping(path = "")
    public List<LastStationModel> getAllLastStations(){
        return this.lastStationService.getAllLastStations();
    }
    @GetMapping(path = "/searchByLastStationId/{id}")
    public Optional<LastStationModel> getLastStationById(@PathVariable("id") int id){
        return this.lastStationService.getLastStationById(id);
    }
    @GetMapping(path = "/searchByStationId/{id}")
    public Optional<LastStationModel> getLastStationByStationId(@PathVariable("id") int station_id){
        return this.lastStationService.getLastStationById(station_id);
    }

    //<------GET

    //POST------>
    @PostMapping(path = "")
    public LastStationModel addLastStation(@RequestBody LastStationModel lastStation){
        return this.lastStationService.addLastStation(lastStation);
    }
    //<------POST

    //DELETE------>
    @DeleteMapping(path = "/{id}")
    public void deleteLastStationById(@PathVariable("id") int id){
        this.lastStationService.deleteLastStationById(id);
    }
    //<------DELETE

    //PUT------>
    @PutMapping(path = "/{id}")
    public void editLastStation(@PathVariable("id") int id, @RequestBody LastStationModel lastStation){
        this.lastStationService.editLastStation(id, lastStation);
    }
    //<------PUT
}
