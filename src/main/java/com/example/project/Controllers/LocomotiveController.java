package com.example.project.Controllers;

import com.example.project.Models.LocomotiveModel;
import com.example.project.Services.LocomotiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/locomotive")
public class LocomotiveController {
    private final LocomotiveService locomotiveService;

    @Autowired
    public LocomotiveController(LocomotiveService locomotiveService){
        this.locomotiveService = locomotiveService;
    }

    //GET------>
    @GetMapping(path = "")
    public List<LocomotiveModel> getAllLocomotives(){
        return this.locomotiveService.getAllLocomotives();
    }
    @GetMapping(path = "/searchById/{id}")
    public Optional<LocomotiveModel> getLocomotiveById(@PathVariable("id") int id){
        return this.locomotiveService.getLocomotiveById(id);
    }
    @GetMapping(path = "/searchBySeries/{series}")
    public List<LocomotiveModel> getLocomotiveBySeries(@PathVariable("series") int series){
        return this.locomotiveService.getLocomotiveBySeries(series);
    }
    @GetMapping(path = "/searchByNumber/{number}")
    public List<LocomotiveModel> getLocomotiveByNumber(@PathVariable("number") int number){
        return this.locomotiveService.getLocomotiveByNumber(number);
    }
    @GetMapping(path = "/searchByPower/{power}")
    public List<LocomotiveModel> getLocomotiveByPower(@PathVariable("power") int power){
        return this.locomotiveService.getLocomotiveByPower(power);
    }
    @GetMapping(path = "/searchByStatus/{status}")
    public List<LocomotiveModel> getLocomotiveByStatus(@PathVariable("status") String status){
        return this.locomotiveService.getLocomotiveByStatus(status);
    }
    //<------GET

    //POST------>
    @PostMapping(path = "")
    public LocomotiveModel addLocomotive(@RequestBody LocomotiveModel locomotive){
        return this.locomotiveService.addLocomotive(locomotive);
    }
    //<------POST

    //DELETE------>
    @DeleteMapping(path = "/{id}")
    public void deleteLocomotiveById(@PathVariable("id") int id){
        this.locomotiveService.deleteLocomotiveById(id);
    }
    //<------DELETE

    //PUT------>
    @PutMapping(path = "/{id}")
    public void editLocomotive(@PathVariable("id") int id, @RequestBody LocomotiveModel locomotive){
        this.locomotiveService.editLocomotive(id, locomotive);
    }
    //<------PUT
}
