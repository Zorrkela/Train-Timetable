package com.example.project.Controllers;

import com.example.project.Models.StartStationModel;
import com.example.project.Services.StartStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/startStation")
public class StartStationController {
    private final StartStationService startStationService;

    @Autowired
    public StartStationController(StartStationService startStationService){
        this.startStationService = startStationService;
    }
    //GET------>
    @GetMapping(path = "")
    public List<StartStationModel> getAllStartStations(){
        return this.startStationService.getAllStartStations();
    }
    @GetMapping(path = "/searchByStartStationId/{id}")
    public Optional<StartStationModel> getStartStationById(@PathVariable("id") int id){
        return this.startStationService.getStartStationById(id);
    }
    @GetMapping(path = "/searchByStationId/{id}")
    public Optional<StartStationModel> getStartStationByStationId(@PathVariable("id") int station_id){
        return this.startStationService.getStartStationById(station_id);
    }

    //<------GET

    //POST------>
    @PostMapping(path = "")
    public StartStationModel addStartStation(@RequestBody StartStationModel startStation){
        return this.startStationService.addStartStation(startStation);
    }
    //<------POST

    //DELETE------>
    @DeleteMapping(path = "/{id}")
    public void deleteStartStationById(@PathVariable("id") int id){
        this.startStationService.deleteStartStationById(id);
    }
    //<------DELETE

    //PUT------>
    @PutMapping(path = "/{id}")
    public void editStartStation(@PathVariable("id") int id, @RequestBody StartStationModel startStation){
        this.startStationService.editStartStation(id, startStation);
    }
    //<------PUT
}
