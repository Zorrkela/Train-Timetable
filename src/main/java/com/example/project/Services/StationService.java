package com.example.project.Services;

import com.example.project.Models.StationModel;
import com.example.project.Repositories.StationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StationService {
    private final StationRepository stationRepository;

    @Autowired
    public StationService(StationRepository stationRepository){
        this.stationRepository = stationRepository;
    }
    //GET------>
    public List<StationModel> getAllStations(){
        return this.stationRepository.findAll();
    }
    public Optional<StationModel> getStationById(int id){
        return this.stationRepository.findById(id);
    }
    public List<StationModel> getStationByName(String type){
        return this.stationRepository.findByName(type);
    }
    public List<StationModel> getStationByLocation(String location){
        return this.stationRepository.findByLocation(location);
    }
    //<------GET

    //POST------>
    public StationModel addStation(StationModel station){
        return this.stationRepository.save(station);
    }
    //<------POST

    //DELETE------>
    public void deleteStationById(int id){
        this.stationRepository.deleteById(id);
    }
    //<------DELETE

    //PUT------>
    @Transactional
    public void editStation(int id, StationModel updatedStation){
        Optional<StationModel> currentStation = this.stationRepository.findById(id);
        StationModel finalStation = new StationModel();
        finalStation.setId(id);

        if(updatedStation.getName() == null){
            finalStation.setName(currentStation.get().getName());
        }

        else{
            finalStation.setName(updatedStation.getName());
        }

        if (updatedStation.getLocation() == null){
            finalStation.setLocation(currentStation.get().getLocation());
        }

        else{
            finalStation.setLocation(currentStation.get().getLocation());
        }

        this.stationRepository.updateStation(finalStation.getId(), finalStation.getName(), finalStation.getLocation());
    }
    //<------PUT
}
