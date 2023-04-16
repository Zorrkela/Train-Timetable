package com.example.project.Models;

import jakarta.persistence.*;

@Entity(name = "wagon")
public class WagonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wagon_id")
    private int id;

    @Column(name = "type_of_wagon")
    private String typeOfWagon;

    @Column(name = "status")
    private String status;

    @Column(name = "weight(t)")
    private String weight;

    public WagonModel(int id, String typeOfWagon, String status, String weight) {
        this.id = id;
        this.typeOfWagon = typeOfWagon;
        this.status = status;
        this.weight = weight;
    }

    public WagonModel() {

    }


    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getTypeOfWagon(){
        return typeOfWagon;
    }
    public void setTypeOfWagon(String typeOfWagon){
        this.typeOfWagon = typeOfWagon;
    }
    public String getStatusOfWagon(){
        return status;
    }
    public void setStatusOfWagon(String status){
        this.status = status;
    }
    public String getWeightOfWagon(){
        return weight;
    }
    public void setWeightOfWagon(String weight){
        this.weight = weight;
    }
    @Override
    public String toString() {
        return "WagonModel [id=" + id + ", typeOfWagon=" + typeOfWagon + ", status=" + status + ", weight=" + weight
                + "]";
    }
}
