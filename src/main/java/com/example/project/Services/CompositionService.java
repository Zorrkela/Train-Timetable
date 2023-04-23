package com.example.project.Services;

import com.example.project.Models.CompositionModel;
import com.example.project.Repositories.CompositionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompositionService {
    private final CompositionRepository compositionRepository;

    @Autowired
    public CompositionService(CompositionRepository compositionRepository){
        this.compositionRepository = compositionRepository;
    }
    //GET------>
    public List<CompositionModel> getAllCompositions(){
        return this.compositionRepository.findAll();
    }
    public Optional<CompositionModel> getCompositionById(int id){
        return this.compositionRepository.findById(id);
    }
    public List<CompositionModel> getCompositionByLocomotiveId(int locomotive_id){
        return this.compositionRepository.findByLocomotiveId(locomotive_id);
    }
    public List<CompositionModel> getCompositionByWagonId(int wagon_id){
        return this.compositionRepository.findByWagonId(wagon_id);
    }
    //<------GET

    //POST------>
    public CompositionModel addComposition(CompositionModel composition){
        return this.compositionRepository.save(composition);
    }
    //<------POST

    //DELETE------>
    public void deleteCompositionById(int id){
        this.compositionRepository.deleteById(id);
    }
    //<------DELETE

    //PUT------>
    @Transactional
    public void editComposition(int id, CompositionModel updatedComposition){
        Optional<CompositionModel> currentComposition = this.compositionRepository.findById(id);
        CompositionModel finalComposition = new CompositionModel();
        finalComposition.setId(id);

        if(updatedComposition.getLocomotiveId() == 0){
            finalComposition.setLocomotiveId(currentComposition.get().getLocomotiveId());
        }

        else{
            finalComposition.setLocomotiveId(updatedComposition.getLocomotiveId());
        }

        if (updatedComposition.getWagonId() == 0){
            finalComposition.setWagonId(currentComposition.get().getWagonId());
        }

        else{
            finalComposition.setWagonId(currentComposition.get().getWagonId());
        }

        this.compositionRepository.updateComposition(finalComposition.getId(), finalComposition.getLocomotiveId(), finalComposition.getWagonId());
    }
    //<------PUT
}
