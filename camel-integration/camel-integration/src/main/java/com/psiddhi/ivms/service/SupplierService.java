package com.psiddhi.ivms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.psiddhi.ivms.model.Supplier;
import com.psiddhi.ivms.repository.SupplierRepository;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(
            SupplierRepository supplierRepository) {

        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.getAllSuppliers();
    }
}