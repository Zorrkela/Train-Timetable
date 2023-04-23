package com.example.project.Services;

import com.example.project.Models.StartStationModel;
import com.example.project.Repositories.StartStationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StartStationService {
    private final StartStationRepository startStationRepository;

    @Autowired
    public StartStationService(StartStationRepository startStationRepository){
        this.startStationRepository = startStationRepository;
    }
    //GET------>
    public List<StartStationModel> getAllStartStations(){
        return this.startStationRepository.findAll();
    }
    public Optional<StartStationModel> getStartStationById(int id){
        return this.startStationRepository.findById(id);
    }
    public List<StartStationModel> getStationById(int stationId){
        return this.startStationRepository.findByStationId(stationId);
    }
    //<------GET

    //POST------>
    public StartStationModel addStartStation(StartStationModel startStation){
        return this.startStationRepository.save(startStation);
    }
    //<------POST

    //DELETE------>
    public void deleteStartStationById(int id){
        this.startStationRepository.deleteById(id);
    }
    //<------DELETE

    //PUT------>
    @Transactional
    public void editStartStation(int id, StartStationModel updatedStartStation){
        Optional<StartStationModel> currentStartStation = this.startStationRepository.findById(id);
        StartStationModel finalStartStation = new StartStationModel();
        finalStartStation.setId(id);

        if(updatedStartStation.getStationId() == 0){
            finalStartStation.setStationId(currentStartStation.get().getStationId());
        }

        else{
            finalStartStation.setStationId(updatedStartStation.getStationId());
        }

        this.startStationRepository.updateStartStation(finalStartStation.getId(), finalStartStation.getStationId());
    }
    //<------PUT
}
