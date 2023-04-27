package com.example.project.Models;

import jakarta.persistence.*;
import lombok.Data;


@Entity(name = "train_driver")
@Data
public class TrainDriverModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "train_driver_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "personal_number")
    private String personalNumber;

    @Column(name= "origin_station_id")
    private int originStationId;

}
