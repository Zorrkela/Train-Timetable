package com.example.project.Services;

import com.example.project.Models.WagonModel;
import com.example.project.Repositories.WagonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WagonService {
    private final WagonRepository wagonRepository;

    @Autowired
    public WagonService(WagonRepository wagonRepository){
        this.wagonRepository = wagonRepository;
    }
    //GET------>
    public List<WagonModel> getAllWagons(){
        return this.wagonRepository.findAll();
    }
    public Optional<WagonModel> getWagonById(int id){
        return this.wagonRepository.findById(id);
    }
    public List<WagonModel> getWagonByType(String type){
        return this.wagonRepository.findByType(type);
    }
    public List<WagonModel> getWagonByStatus(String status){
        return this.wagonRepository.findByStatus(status);
    }
    public List<WagonModel> getWagonByWeight(String weight){
        return this.wagonRepository.findByWeight(weight);
    }
    //<------GET

    //POST------>
    public WagonModel addWagon(WagonModel wagon){
        return this.wagonRepository.save(wagon);
    }
    //<------POST

    //DELETE------>
    public void deleteWagonById(int id){
        this.wagonRepository.deleteById(id);
    }
    //<------DELETE

    //PUT------>
    @Transactional
    public void editWagon(int id, WagonModel updatedWagon){
        Optional<WagonModel> currentWagons = this.wagonRepository.findById(id);
        WagonModel finalWagon = new WagonModel();
        finalWagon.setId(id);

        if(updatedWagon.getType() == null){
            finalWagon.setType(currentWagons.get().getType());
        }

        else{
            finalWagon.setType(updatedWagon.getType());
        }

        if (updatedWagon.getStatus() == null){
            finalWagon.setStatus(currentWagons.get().getStatus());
        }

        else{
            finalWagon.setStatus(currentWagons.get().getStatus());
        }

        if(updatedWagon.getWeight() == null){
            finalWagon.setWeight(currentWagons.get().getWeight());
        }

        else{
            finalWagon.setWeight(updatedWagon.getWeight());
        }
        this.wagonRepository.updateWagon(finalWagon.getId(), finalWagon.getType(), finalWagon.getStatus(), finalWagon.getWeight());
    }
    //<------PUT
}


