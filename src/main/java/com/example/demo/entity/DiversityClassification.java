package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "diversity_classifications")
public class DiversityClassification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String code;
    private String description;
    private Boolean active;
    
    @PrePersist
    public void preSave() {
        this.active = true;
    }
    
    // Constructors
    public DiversityClassification() {}
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}