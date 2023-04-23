package com.example.project.Controllers;

import com.example.project.Models.TrainModel;
import com.example.project.Services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/train")
public class TrainController {
    private final TrainService trainService;

    @Autowired
    public TrainController(TrainService trainService){
        this.trainService = trainService;
    }

    //GET------>
    @GetMapping(path = "")
    public List<TrainModel> getAllTrains(){
        return this.trainService.getAllTrains();
    }
    @GetMapping(path = "/searchByTrainNumber/{id}")
    public Optional<TrainModel> getTrainById(@PathVariable("id") int id){
        return this.trainService.getTrainById(id);
    }
    @GetMapping(path = "/searchByTimeOfDeparture/{time}")
    public List<TrainModel> getTrainByTime(@PathVariable("time") Time time){
        return this.trainService.getTrainByTime(time);
    }
    @GetMapping(path = "/searchByWeight/{weight}")
    public List<TrainModel> getTrainByWeight(@PathVariable("weight") int weight){
        return this.trainService.getTrainByWeight(weight);
    }
    @GetMapping(path = "/searchByCompositionId/{compositionId}")
    public List<TrainModel> getTrainByCompositionId(@PathVariable("compositionId") int compositionId){
        return this.trainService.getTrainByCompositionId(compositionId);
    }
    @GetMapping(path = "/searchByStartStationId/{startStationId}")
    public List<TrainModel> getTrainByStartStationId(@PathVariable("startStationId") int startStationId){
        return this.trainService.getTrainByStartStationId(startStationId);
    }
    @GetMapping(path = "/searchByLastStationId/{lastStationId}")
    public List<TrainModel> getTrainByLastStationId(@PathVariable("lastStationId") int lastStationId){
        return this.trainService.getTrainByLastStationId(lastStationId);
    }
    //<------GET

    //POST------>
    @PostMapping(path = "")
    public TrainModel addTrain(@RequestBody TrainModel train){
        return this.trainService.addTrain(train);
    }
    //<------POST

    //DELETE------>
    @DeleteMapping(path = "/{id}")
    public void deleteTrainById(@PathVariable("id") int id){
        this.trainService.deleteTrainById(id);
    }
    //<------DELETE

    //PUT------>
    @PutMapping(path = "/{id}")
    public void editTrain(@PathVariable("id") int id, @RequestBody TrainModel train){
        this.trainService.editTrain(id, train);
    }
    //<------PUT
}
