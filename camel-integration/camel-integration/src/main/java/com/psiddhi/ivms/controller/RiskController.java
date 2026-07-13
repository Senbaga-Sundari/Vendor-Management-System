package com.psiddhi.ivms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psiddhi.ivms.model.VendorRisk;
import com.psiddhi.ivms.service.RiskService;

@RestController
public class RiskController {

    private final RiskService riskService;

    public RiskController(RiskService riskService) {
        this.riskService = riskService;
    }

    @GetMapping("/api/risk")
    public List<VendorRisk> getVendorRisk() {
        return riskService.calculateRisk();
    }
}