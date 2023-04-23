package com.example.project.Controllers;

import com.example.project.Models.WagonModel;
import com.example.project.Services.WagonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/wagon")
public class WagonController {
    private final WagonService wagonService;

    @Autowired
    public WagonController(WagonService wagonService){
        this.wagonService = wagonService;
    }

    //GET------>
    @GetMapping(path = "")
    public List<WagonModel> getAllWagons(){
        return this.wagonService.getAllWagons();
    }
    @GetMapping(path = "/searchById/{id}")
    public Optional<WagonModel> getWagonById(@PathVariable("id") int id){
        return this.wagonService.getWagonById(id);
    }
    @GetMapping(path = "/searchByType/{type}")
    public List<WagonModel> getWagonByType(@PathVariable("type") String type){
        return this.wagonService.getWagonByType(type);
    }

    @GetMapping(path = "/searchByStatus/{status}")
    public List<WagonModel> getWagonByStatus(@PathVariable("status") String status){
        return this.wagonService.getWagonByStatus(status);
    }
    @GetMapping(path = "/searchByWeight/{weight}")
    public List<WagonModel> getWagonByWeight(@PathVariable("weight") String weight){
        return this.wagonService.getWagonByWeight(weight);
    }
    //<------GET

    //POST------>
    @PostMapping(path = "")
    public WagonModel addWagon(@RequestBody WagonModel wagon){
        return this.wagonService.addWagon(wagon);
    }
    //<------POST

    //DELETE------>
    @DeleteMapping(path = "/{id}")
    public void deleteWagonById(@PathVariable("id") int id){
        this.wagonService.deleteWagonById(id);
    }
    //<------DELETE

    //PUT------>
    @PutMapping(path = "/{id}")
    public void editWagon(@PathVariable("id") int id, @RequestBody WagonModel wagon){
        this.wagonService.editWagon(id, wagon);
    }
    //<------PUT
}
