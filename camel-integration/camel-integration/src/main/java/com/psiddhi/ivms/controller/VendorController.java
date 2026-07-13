package com.psiddhi.ivms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psiddhi.ivms.model.IntegratedVendor;
import com.psiddhi.ivms.service.VendorIntegrationService;

@RestController
public class VendorController {

    @Autowired
    private VendorIntegrationService service;

    @GetMapping("/test")
    public String test() {
        return "Controller Working";
    }

    @GetMapping("/vendors")
    public List<IntegratedVendor> getAll() {
        return service.integrate();
    }
}