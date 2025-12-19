package com.example.demo.controller;

import com.example.demo.entity.SpendCategory;
import com.example.demo.service.SpendCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class SpendCategoryController {

    private final SpendCategoryService service;

    public SpendCategoryController(SpendCategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<SpendCategory> getAll() {
        return service.getAllCategories();
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        service.deactivateCategory(id);
    }
}
