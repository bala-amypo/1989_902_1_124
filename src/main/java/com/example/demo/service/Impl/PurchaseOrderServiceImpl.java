package com.example.demo.service.impl;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.entity.Supplier;
import com.example.demo.entity.SpendCategory;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.PurchaseOrderRepository;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.repository.SpendCategoryRepository;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    private final PurchaseOrderRepository purchaseOrderRepository;
    private final SupplierRepository supplierRepository;
    private final SpendCategoryRepository spendCategoryRepository;
    
    public PurchaseOrderServiceImpl(PurchaseOrderRepository purchaseOrderRepository,
                                   SupplierRepository supplierRepository,
                                   SpendCategoryRepository spendCategoryRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
        this.supplierRepository = supplierRepository;
        this.spendCategoryRepository = spendCategoryRepository;
    }
    
    @Override
    public PurchaseOrder createPurchaseOrder(PurchaseOrder purchaseOrder) {
        if (purchaseOrder.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new BadRequestException("Amount must be positive");
        }
        
        Supplier supplier = supplierRepository.findById(purchaseOrder.getSupplier().getId()).orElse(null);
        if (supplier == null || !supplier.getIsActive()) {
            throw new BadRequestException("Supplier is not active");
        }
        
        SpendCategory category = spendCategoryRepository.findById(purchaseOrder.getCategory().getId()).orElse(null);
        if (category == null || !category.getActive()) {
            throw new BadRequestException("Category is not active");
        }
        
        return purchaseOrderRepository.save(purchaseOrder);
    }
    
    @Override
    public List<PurchaseOrder> getPurchaseOrdersBySupplier(Long supplierId) {
        return purchaseOrderRepository.findBySupplier_Id(supplierId);
    }
}