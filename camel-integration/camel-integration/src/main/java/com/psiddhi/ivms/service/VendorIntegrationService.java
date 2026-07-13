package com.psiddhi.ivms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.psiddhi.ivms.model.*;
import com.psiddhi.ivms.repository.VendorRepository;

@Service
public class VendorIntegrationService {

    public List<IntegratedVendor> integrate() {

        List<IntegratedVendor> vendors = new ArrayList<>();

        for(String vendorId : VendorRepository.suppliers.keySet()){

            IntegratedVendor iv = new IntegratedVendor();

            iv.setSupplier(
                    VendorRepository.suppliers.get(vendorId));

            iv.setFinance(
                    VendorRepository.finances.get(vendorId));

            iv.setPerformance(
                    VendorRepository.performances.get(vendorId));

            iv.setContract(
                    VendorRepository.contracts.get(vendorId));

            vendors.add(iv);

        }

        return vendors;

    }

}
