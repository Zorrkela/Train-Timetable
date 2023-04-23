package com.example.project.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "composition")
@Data
public class CompositionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "composition_id")
    private int id;

    @Column(name = "locomotive_id")
    private int locomotiveId;

    @Column(name = "wagon_id")
    private int wagonId;
}
