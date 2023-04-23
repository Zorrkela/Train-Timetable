package com.example.project.Models;


import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "start_station")
@Data
public class StartStationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "start_station_id")
    private int id;

    @Column(name = "station_id")
    private int stationId;
}
