package com.example.project.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "locomotive")
@Data
public class LocomotiveModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "locomotive_id")
    private int id;

    @Column(name = "series")
    private int series;

    @Column(name = "number")
    private int number;

    @Column(name = "power")
    private int power;

    @Column(name= "status")
    private String status;
}
