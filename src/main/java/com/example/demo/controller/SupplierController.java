package com.example.demo.controller;

import com.example.demo.service.SupplierService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupplierController {
    private final SupplierService supplierService;
    
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }
}