package com.example.project.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "last_station")
@Data
public class LastStationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "last_station_id")
    private int id;

    @Column(name = "station_id")
    private int stationId;
}
