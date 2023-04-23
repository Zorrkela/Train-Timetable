package com.example.project.Controllers;

import com.example.project.Models.CompositionModel;
import com.example.project.Services.CompositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/composition")
public class CompositionController {
    private final CompositionService compositionService;

    @Autowired
    public CompositionController(CompositionService compositionService){
        this.compositionService = compositionService;
    }
    //GET------>
    @GetMapping(path = "")
    public List<CompositionModel> getAllCompositions(){
        return this.compositionService.getAllCompositions();
    }
    @GetMapping(path = "/searchById/{id}")
    public Optional<CompositionModel> getCompositionById(@PathVariable("id") int id){
        return this.compositionService.getCompositionById(id);
    }
    @GetMapping(path = "/searchByLocomotiveId/{id}")
    public List<CompositionModel> getCompositionByLocomotiveId(@PathVariable("id") int locomotive_id){
        return this.compositionService.getCompositionByLocomotiveId(locomotive_id);
    }

    @GetMapping(path = "/searchByWagonId/{id}")
    public List<CompositionModel> getCompositionByWagonId(@PathVariable("id") int wagon_id){
        return this.compositionService.getCompositionByWagonId(wagon_id);
    }
    //<------GET

    //POST------>
    @PostMapping(path = "")
    public CompositionModel addComposition(@RequestBody CompositionModel composition){
        return this.compositionService.addComposition(composition);
    }
    //<------POST

    //DELETE------>
    @DeleteMapping(path = "/{id}")
    public void deleteCompositionById(@PathVariable("id") int id){
        this.compositionService.deleteCompositionById(id);
    }
    //<------DELETE

    //PUT------>
    @PutMapping(path = "/{id}")
    public void editComposition(@PathVariable("id") int id, @RequestBody CompositionModel composition){
        this.compositionService.editComposition(id, composition);
    }
    //<------PUT
}
