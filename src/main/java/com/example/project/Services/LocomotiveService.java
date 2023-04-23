package com.example.project.Services;

import com.example.project.Models.LocomotiveModel;
import com.example.project.Repositories.LocomotiveRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocomotiveService {
    private final LocomotiveRepository locomotiveRepository;

    @Autowired
    public LocomotiveService(LocomotiveRepository locomotiveRepository){
        this.locomotiveRepository = locomotiveRepository;
    }

    //GET------>
    public List<LocomotiveModel> getAllLocomotives(){
        return this.locomotiveRepository.findAll();
    }
    public Optional<LocomotiveModel> getLocomotiveById(int id){
        return this.locomotiveRepository.findById(id);
    }
    public List<LocomotiveModel> getLocomotiveBySeries(int series){
        return this.locomotiveRepository.findBySeries(series);
    }
    public List<LocomotiveModel> getLocomotiveByNumber(int number){
        return this.locomotiveRepository.findByNumber(number);
    }
    public List<LocomotiveModel> getLocomotiveByPower(int power){
        return this.locomotiveRepository.findByPower(power);
    }
    public List<LocomotiveModel> getLocomotiveByStatus(String status){
        return this.locomotiveRepository.findByStatus(status);
    }

    //<------GET

    //SET------>
    public LocomotiveModel addLocomotive(LocomotiveModel locomotive){
        return this.locomotiveRepository.save(locomotive);
    }
    //<------SET

    //DELETE------>
    public void deleteLocomotiveById(int id){
        this.locomotiveRepository.deleteById(id);
    }
    //<------DELETE

    //PUT------>
    @Transactional
    public void editLocomotive(int id, LocomotiveModel updatedLocomotive){
        Optional<LocomotiveModel> currentLocomotive = this.locomotiveRepository.findById(id);
        LocomotiveModel finalLocomotive = new LocomotiveModel();
        finalLocomotive.setId(id);

        if(updatedLocomotive.getSeries() == 0){
            finalLocomotive.setSeries(currentLocomotive.get().getSeries());
        }

        else{
            finalLocomotive.setSeries(updatedLocomotive.getSeries());
        }
        if(updatedLocomotive.getNumber() == 0){
            finalLocomotive.setNumber(currentLocomotive.get().getNumber());
        }

        else{
            finalLocomotive.setNumber(updatedLocomotive.getNumber());
        }

        if (updatedLocomotive.getPower() == 0){
            finalLocomotive.setPower(currentLocomotive.get().getPower());
        }

        else{
            finalLocomotive.setPower(currentLocomotive.get().getPower());
        }

        if (updatedLocomotive.getStatus() == null){
            finalLocomotive.setStatus(currentLocomotive.get().getStatus());
        }

        else{
            finalLocomotive.setStatus(currentLocomotive.get().getStatus());
        }
        this.locomotiveRepository.updateLocomotive(finalLocomotive.getId(), finalLocomotive.getSeries(), finalLocomotive.getNumber(), finalLocomotive.getPower(), finalLocomotive.getStatus());
    }
    //<------PUT
}
