package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "diversity_targets")
public class DiversityTarget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int targetYear;
    private Double targetPercentage;
    private Boolean active;

    @ManyToOne
    private DiversityClassification classification;

    @PrePersist
    void preSave() {
        if (active == null) active = true;
    }

    public DiversityTarget() {}
}
