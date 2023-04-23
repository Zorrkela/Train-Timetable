package com.example.project.Controllers;

import com.example.project.Models.StationModel;
import com.example.project.Services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stations")
public class StationController {
    private final StationService stationService;

    @Autowired
    public StationController(StationService stationService){
        this.stationService = stationService;
    }
    //GET------>
    @GetMapping(path = "")
    public List<StationModel> getAllStations(){
        return this.stationService.getAllStations();
    }
    @GetMapping(path = "/searchById/{id}")
    public Optional<StationModel> getStationById(@PathVariable("id") int id){
        return this.stationService.getStationById(id);
    }
    @GetMapping(path = "/searchByName/{name}")
    public List<StationModel> getStationByName(@PathVariable("name") String name){
        return this.stationService.getStationByName(name);
    }

    @GetMapping(path = "/searchByLocation/{location}")
    public List<StationModel> getStationByLocation(@PathVariable("location") String location){
        return this.stationService.getStationByLocation(location);
    }
    //<------GET

    //POST------>
    @PostMapping(path = "")
    public StationModel addStation(@RequestBody StationModel station){
        return this.stationService.addStation(station);
    }
    //<------POST

    //DELETE------>
    @DeleteMapping(path = "/{id}")
    public void deleteStationById(@PathVariable("id") int id){
        this.stationService.deleteStationById(id);
    }
    //<------DELETE

    //PUT------>
    @PutMapping(path = "/{id}")
    public void editStation(@PathVariable("id") int id, @RequestBody StationModel station){
        this.stationService.editStation(id, station);
    }
    //<------PUT
}
