package com.example.Project.Services;

import com.example.Project.Models.WagonModel;
import com.example.Project.Repositories.WagonRepository;
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
    public List<WagonModel> getAllWagons(){
        return this.wagonRepository.findAll();
    }
    public Optional<WagonModel> getWagonById(int id){
        return this.wagonRepository.findById(id);
    }
    public Optional<WagonModel> getWagonByStatus(String status){
        return this.wagonRepository.findByWagonStatus(status);
    }
    public WagonModel addWagon(WagonModel wagon){
        return this.wagonRepository.save(wagon);
    }
    public void deleteWagonById(int id){
        this.wagonRepository.deleteById(id);
    }
    @Transactional
    public void editWagon(int id, WagonModel updatedWagon){
        Optional<WagonModel> currentWagons = this.wagonRepository.findById(id);
        WagonModel finalWagon = new WagonModel();
        finalWagon.setId(id);

        if(updatedWagon.getTypeOfWagon() == null){
            finalWagon.setTypeOfWagon(currentWagons.get().getTypeOfWagon());
        }

        else{
            finalWagon.setTypeOfWagon(updatedWagon.getTypeOfWagon());
        }

        if (updatedWagon.getStatusOfWagon() == null){
            finalWagon.setStatusOfWagon(currentWagons.get().getStatusOfWagon());
        }

        else{
            finalWagon.setStatusOfWagon(currentWagons.get().getStatusOfWagon());
        }

        if(updatedWagon.getWeightOfWagon() == null){
            finalWagon.setWeightOfWagon(currentWagons.get().getWeightOfWagon());
        }

        else{
            finalWagon.setWeightOfWagon(updatedWagon.getWeightOfWagon());
        }
        this.wagonRepository.updateWagon(finalWagon.getId(), finalWagon.getTypeOfWagon(), finalWagon.getStatusOfWagon(), finalWagon.getWeightOfWagon());
    }
}
