package com.example.project.Controllers;

import com.example.project.Models.TrainDriverModel;
import com.example.project.Services.TrainDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/train-driver")
public class TrainDriverController {
    private final TrainDriverService trainDriverService;

    @Autowired
    public TrainDriverController(TrainDriverService trainDriverService){
        this.trainDriverService = trainDriverService;
    }

    //GET------>
    @GetMapping(path = "")
    public List<TrainDriverModel> getAllTrainDrivers(){
        return this.trainDriverService.getAllTrainDrivers();
    }
    @GetMapping(path = "/searchByDriverId/{id}")
    public Optional<TrainDriverModel> getDriverById(@PathVariable("id") int id){
        return this.trainDriverService.getDriverById(id);
    }
    @GetMapping(path = "/searchByName/{name}")
    public List<TrainDriverModel> getDriverByName(@PathVariable("name") String name){
        return this.trainDriverService.getDriverByName(name);
    }
    @GetMapping(path = "/searchBySurname/{surname}")
    public List<TrainDriverModel> getDriverBySurname(@PathVariable("surname") String surname){
        return this.trainDriverService.getDriverBySurname(surname);
    }
    @GetMapping(path = "/searchByPersonalNumber/{personalNumber}")
    public List<TrainDriverModel> getDriverByPersonalNumber(@PathVariable("personalNumber") String personalNumber){
        return this.trainDriverService.getDriverByPersonalNumber(personalNumber);
    }
    @GetMapping(path = "/searchByOriginStationId/{originStationId}")
    public List<TrainDriverModel> getDriverByOriginStationId(@PathVariable("originStationId") int originStationId){
        return this.trainDriverService.getDriverByOriginStationId(originStationId);
    }
    //<------GET

    //POST------>
    @PostMapping(path = "")
    public TrainDriverModel addTrainDriver(@RequestBody TrainDriverModel trainDriver){
        return this.trainDriverService.addTrainDriver(trainDriver);
    }
    //<------POST

    //DELETE------>
    @DeleteMapping(path = "/{id}")
    public void deleteDriverById(@PathVariable("id") int id){
        this.trainDriverService.deleteDriverById(id);
    }
    //<------DELETE

    //PUT------>
    @PutMapping(path = "/{id}")
    public void editTrainDriver(@PathVariable("id") int id, @RequestBody TrainDriverModel trainDriver){
        this.trainDriverService.editTrainDriver(id, trainDriver);
    }
    //<------PUT
}
