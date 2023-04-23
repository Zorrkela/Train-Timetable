package com.example.project.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "stations")
@Data
public class StationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "station_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

}
