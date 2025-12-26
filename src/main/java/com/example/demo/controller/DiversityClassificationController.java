package com.example.demo.controller;

import com.example.demo.service.DiversityClassificationService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiversityClassificationController {
    private final DiversityClassificationService service;
    
    public DiversityClassificationController(DiversityClassificationService service) {
        this.service = service;
    }
}