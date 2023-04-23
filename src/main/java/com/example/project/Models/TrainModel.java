package com.example.project.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;

@Entity(name = "train")
@Data
public class TrainModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "train_number")
    private int id;

    @Column(name = "time_of_departure")
    private Time time;

    @Column(name = "weight")
    private int weight;

    @Column(name = "composition_id")
    private int compositionId;

    @Column(name= "start_station_id")
    private int startStationId;

    @Column(name = "last_station_id")
    private int lastStationId;
}
