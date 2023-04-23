package com.example.project.Services;

import com.example.project.Models.LastStationModel;
import com.example.project.Repositories.LastStationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LastStationService {
    private final LastStationRepository lastStationRepository;

    @Autowired
    public LastStationService(LastStationRepository lastStationRepository){
        this.lastStationRepository = lastStationRepository;
    }
    //GET------>
    public List<LastStationModel> getAllLastStations(){
        return this.lastStationRepository.findAll();
    }
    public Optional<LastStationModel> getLastStationById(int id){
        return this.lastStationRepository.findById(id);
    }
    public List<LastStationModel> getStationById(int stationId){
        return this.lastStationRepository.findByStationId(stationId);
    }
    //<------GET

    //POST------>
    public LastStationModel addLastStation(LastStationModel lastStation){
        return this.lastStationRepository.save(lastStation);
    }
    //<------POST

    //DELETE------>
    public void deleteLastStationById(int id){
        this.lastStationRepository.deleteById(id);
    }
    //<------DELETE

    //PUT------>
    @Transactional
    public void editLastStation(int id, LastStationModel updatedLastStation){
        Optional<LastStationModel> currentLastStation = this.lastStationRepository.findById(id);
        LastStationModel finalLastStation = new LastStationModel();
        finalLastStation.setId(id);

        if(updatedLastStation.getStationId() == 0){
            finalLastStation.setStationId(currentLastStation.get().getStationId());
        }

        else{
            finalLastStation.setStationId(updatedLastStation.getStationId());
        }

        this.lastStationRepository.updateLastStation(finalLastStation.getId(), finalLastStation.getStationId());
    }
    //<------PUT
}
