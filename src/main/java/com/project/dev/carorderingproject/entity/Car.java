package com.project.dev.carorderingproject.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String manufacturer;
    private int productionYear;
    private double price;
    private boolean available;

    // Constructors, getters, setters (omitted for brevity)
}


