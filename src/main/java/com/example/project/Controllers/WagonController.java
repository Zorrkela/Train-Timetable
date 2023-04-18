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

    @GetMapping(path = "")
    public List<WagonModel> getAllWagons(){
        return this.wagonService.getAllWagons();
    }
    @GetMapping(path = "/{id}")
    public Optional<WagonModel> getWagonById(@PathVariable("id") int id){
        return this.wagonService.getWagonById(id);
    }
    @GetMapping(path = "/{status}")
    public Optional<WagonModel> getWagonByStatus(@PathVariable("status") String status) {
        return this.wagonService.getWagonByStatus(status);
    }
    @PostMapping(path = "")
    public WagonModel addWagon(@RequestBody WagonModel wagon){
        return this.wagonService.addWagon(wagon);
    }
    @DeleteMapping(path = "/{id}")
    public void deleteWagonById(@PathVariable("id") int id){
        this.wagonService.deleteWagonById(id);
    }
    @PutMapping(path = "/{id}")
    public void editWagon(@PathVariable("id") int id, @RequestBody WagonModel wagon){
        this.wagonService.editWagon(id, wagon);
    }
}
