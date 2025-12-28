package com.example.demo.controller;

import com.example.demo.entity.SpendCategory;
import com.example.demo.service.SpendCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class SpendCategoryController {
    private final SpendCategoryService service;
    
    public SpendCategoryController(SpendCategoryService service) {
        this.service = service;
    }
    
    @GetMapping
    public ResponseEntity<List<SpendCategory>> getAllCategories() {
        return ResponseEntity.ok(service.getAllCategories());
    }
    
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivateCategory(@PathVariable Long id) {
        service.deactivateCategory(id);
        return ResponseEntity.ok().build();
    }
}