package com.example.project.Services;

import com.example.project.Models.TrainModel;
import com.example.project.Repositories.TrainRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

@Service
public class TrainService {
    private final TrainRepository trainRepository;

    @Autowired
    public TrainService(TrainRepository trainRepository){
        this.trainRepository = trainRepository;
    }

    //GET------>
    public List<TrainModel> getAllTrains(){
        return this.trainRepository.findAll();
    }
    public Optional<TrainModel> getTrainById(int id){
        return this.trainRepository.findById(id);
    }
    public List<TrainModel> getTrainByTime(Time time){
        return this.trainRepository.findByTime(time);
    }
    public List<TrainModel> getTrainByWeight(int weight){
        return this.trainRepository.findByWeight(weight);
    }
    public List<TrainModel> getTrainByCompositionId(int compositionId){
        return this.trainRepository.findByCompositionId(compositionId);
    }
    public List<TrainModel> getTrainByStartStationId(int startStationId){
        return this.trainRepository.findByStartStationId(startStationId);
    }
    public List<TrainModel> getTrainByLastStationId(int lastStationId){
        return this.trainRepository.findByLastStationId(lastStationId);
    }

    //<------GET

    //SET------>
    public TrainModel addTrain(TrainModel train){
        return this.trainRepository.save(train);
    }
    //<------SET

    //DELETE------>
    public void deleteTrainById(int id){
        this.trainRepository.deleteById(id);
    }
    //<------DELETE

    //PUT------>
    @Transactional
    public void editTrain(int id, TrainModel updatedTrain){
        Optional<TrainModel> currentTrain = this.trainRepository.findById(id);
        TrainModel finalTrain = new TrainModel();
        finalTrain.setId(id);

        if(updatedTrain.getTime() == null){
            finalTrain.setTime(currentTrain.get().getTime());
        }

        else{
            finalTrain.setTime(updatedTrain.getTime());
        }
        if(updatedTrain.getWeight() == 0){
            finalTrain.setWeight(currentTrain.get().getWeight());
        }

        else{
            finalTrain.setWeight(updatedTrain.getWeight());
        }

        if (updatedTrain.getCompositionId() == 0){
            finalTrain.setCompositionId(currentTrain.get().getCompositionId());
        }

        else{
            finalTrain.setCompositionId(currentTrain.get().getCompositionId());
        }

        if (updatedTrain.getStartStationId() == 0){
            finalTrain.setStartStationId(currentTrain.get().getStartStationId());
        }

        else{
            finalTrain.setStartStationId(currentTrain.get().getStartStationId());
        }

        if (updatedTrain.getLastStationId() == 0){
            finalTrain.setLastStationId(currentTrain.get().getLastStationId());
        }

        else{
            finalTrain.setLastStationId(currentTrain.get().getLastStationId());
        }

        this.trainRepository.updateTrain(finalTrain.getId(), finalTrain.getTime(), finalTrain.getWeight(), finalTrain.getCompositionId(), finalTrain.getStartStationId(), finalTrain.getLastStationId());
    }
    //<------PUT
}
