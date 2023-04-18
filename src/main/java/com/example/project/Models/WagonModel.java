package com.example.project.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "wagon")
@Data
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

}
