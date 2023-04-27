package com.example.project.Services;

import com.example.project.Models.TrainDriverModel;
import com.example.project.Repositories.TrainDriverRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainDriverService {
    private final TrainDriverRepository trainDriverRepository;

    @Autowired
    public TrainDriverService(TrainDriverRepository trainDriverRepository){
        this.trainDriverRepository = trainDriverRepository;
    }

    //GET------>
    public List<TrainDriverModel> getAllTrainDrivers(){
        return this.trainDriverRepository.findAll();
    }
    public Optional<TrainDriverModel> getDriverById(int id){
        return this.trainDriverRepository.findById(id);
    }
    public List<TrainDriverModel> getDriverByName(String name){
        return this.trainDriverRepository.findByName(name);
    }
    public List<TrainDriverModel> getDriverBySurname(String surname){
        return this.trainDriverRepository.findBySurname(surname);
    }
    public List<TrainDriverModel> getDriverByPersonalNumber(String personalNumber){
        return this.trainDriverRepository.findByPersonalNumber(personalNumber);
    }
    public List<TrainDriverModel> getDriverByOriginStationId(int originStationId){
        return this.trainDriverRepository.findByOriginStationId(originStationId);
    }
    //<------GET

    //SET------>
    public TrainDriverModel addTrainDriver(TrainDriverModel trainDriver){
        return this.trainDriverRepository.save(trainDriver);
    }
    //<------SET

    //DELETE------>
    public void deleteDriverById(int id){
        this.trainDriverRepository.deleteById(id);
    }
    //<------DELETE

    //PUT------>
    @Transactional
    public void editTrainDriver(int id, TrainDriverModel updatedTrainDriver){
        Optional<TrainDriverModel> currentTrainDriver = this.trainDriverRepository.findById(id);
        TrainDriverModel finalTrainDriver = new TrainDriverModel();
        finalTrainDriver.setId(id);

        if(updatedTrainDriver.getName() == null){
            finalTrainDriver.setName(currentTrainDriver.get().getName());
        }

        else{
            finalTrainDriver.setName(updatedTrainDriver.getName());
        }
        if(updatedTrainDriver.getSurname() == null){
            finalTrainDriver.setSurname(currentTrainDriver.get().getSurname());
        }

        else{
            finalTrainDriver.setSurname(updatedTrainDriver.getSurname());
        }

        if (updatedTrainDriver.getPersonalNumber() == null){
            finalTrainDriver.setPersonalNumber(currentTrainDriver.get().getPersonalNumber());
        }

        else{
            finalTrainDriver.setPersonalNumber(currentTrainDriver.get().getPersonalNumber());
        }

        if (updatedTrainDriver.getOriginStationId() == 0){
            finalTrainDriver.setOriginStationId(currentTrainDriver.get().getOriginStationId());
        }

        else{
            finalTrainDriver.setOriginStationId(currentTrainDriver.get().getOriginStationId());
        }

        this.trainDriverRepository.updateTrainDriver(finalTrainDriver.getId(), finalTrainDriver.getName(), finalTrainDriver.getSurname(), finalTrainDriver.getPersonalNumber(), finalTrainDriver.getOriginStationId());
    }
    //<------PUT
}
