package com.example.demo.controller;

import com.example.demo.service.DiversityTargetService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiversityTargetController {
    private final DiversityTargetService service;
    
    public DiversityTargetController(DiversityTargetService service) {
        this.service = service;
    }
}