package com.example.project.Controllers;

import com.example.project.Models.WagonModel;
import com.example.project.Services.WagonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WagonController {
    private final WagonService wagonService;

    @Autowired
    public WagonController(WagonService wagonService){
        this.wagonService = wagonService;
    }

    @GetMapping(path = "api/wagon")
    public List<WagonModel> getAllWagons(){
        return this.wagonService.getAllWagons();
    }
    @GetMapping(path = "api/wagon/{id}")
    public Optional<WagonModel> getWagonById(@PathVariable("id") int id){
        return this.wagonService.getWagonById(id);
    }
    @GetMapping(path = "api/wagon-by-status/{status}")
    public Optional<WagonModel> getWagonByStatus(@PathVariable("status") String status) {
        return this.wagonService.getWagonByStatus(status);
    }
    @PostMapping(path = "api/wagon")
    public WagonModel addWagon(@RequestBody WagonModel wagon){
        return this.wagonService.addWagon(wagon);
    }
    @DeleteMapping(path = "api/wagon/{id}")
    public void deleteWagonById(@PathVariable("id") int id){
        this.wagonService.deleteWagonById(id);
    }
    @PutMapping(path = "api/wagon/{id}")
    public void editWagon(@PathVariable("id") int id, @RequestBody WagonModel wagon){
        this.wagonService.editWagon(id, wagon);
    }
}
