package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.PurchaseOrderService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRepository poRepository;
    private final SupplierRepository supplierRepository;
    private final SpendCategoryRepository categoryRepository;

    public PurchaseOrderServiceImpl(
            PurchaseOrderRepository poRepository,
            SupplierRepository supplierRepository,
            SpendCategoryRepository categoryRepository) {
        this.poRepository = poRepository;
        this.supplierRepository = supplierRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public PurchaseOrder createPurchaseOrder(PurchaseOrder po) {

        Supplier supplier = supplierRepository.findById(
                        po.getSupplier().getId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Supplier not found"));

        SpendCategory category = categoryRepository.findById(
                        po.getCategory().getId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found"));

        if (!supplier.getIsActive())
            throw new BadRequestException("Supplier inactive");

        if (!category.getActive())
            throw new BadRequestException("Category inactive");

        if (po.getAmount().compareTo(BigDecimal.ZERO) <= 0)
            throw new BadRequestException("Amount must be positive");

        if (po.getDateIssued().isAfter(LocalDate.now()))
            throw new BadRequestException("Future date");

        return poRepository.save(po);
    }

    @Override
    public List<PurchaseOrder> getPurchaseOrdersBySupplier(Long supplierId) {
        return poRepository.findBySupplier_Id(supplierId);
    }
}
