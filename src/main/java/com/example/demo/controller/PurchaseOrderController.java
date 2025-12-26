package com.example.demo.controller;

import com.example.demo.service.PurchaseOrderService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseOrderController {
    private final PurchaseOrderService service;
    
    public PurchaseOrderController(PurchaseOrderService service) {
        this.service = service;
    }
}