package com.example.demo.controller;

import com.example.demo.service.SpendCategoryService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpendCategoryController {
    private final SpendCategoryService service;
    
    public SpendCategoryController(SpendCategoryService service) {
        this.service = service;
    }
}