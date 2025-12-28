package com.example.demo.controller;

import com.example.demo.entity.DiversityClassification;
import com.example.demo.service.DiversityClassificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/classifications")
public class DiversityClassificationController {
    private final DiversityClassificationService service;
    
    public DiversityClassificationController(DiversityClassificationService service) {
        this.service = service;
    }
    
    @GetMapping
    public ResponseEntity<List<DiversityClassification>> getAllClassifications() {
        return ResponseEntity.ok(service.getAllClassifications());
    }
    
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivateClassification(@PathVariable Long id) {
        service.deactivateClassification(id);
        return ResponseEntity.ok().build();
    }
}