package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "diversity_classifications")
public class DiversityClassification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String description;
    private Boolean active;

    @ManyToMany(mappedBy = "diversityClassifications")
    private Set<Supplier> suppliers;

    @PrePersist
    @PreUpdate
    void preSave() {
        if (active == null) active = true;
        if (code != null) code = code.toUpperCase();
    }

    public DiversityClassification() {}

    public DiversityClassification(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
