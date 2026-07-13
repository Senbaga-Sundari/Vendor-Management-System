package com.psiddhi.ivms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psiddhi.ivms.model.Supplier;
import com.psiddhi.ivms.service.SupplierService;

@RestController
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(
            SupplierService supplierService) {

        this.supplierService = supplierService;
    }

    @GetMapping("/suppliers")
    public List<Supplier> getSuppliers() {

        return supplierService.getAllSuppliers();
    }
}
