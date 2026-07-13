package com.psiddhi.ivms.controller;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psiddhi.ivms.model.Performance;

@RestController
public class PerformanceController {

    private final JdbcTemplate jdbcTemplate;

    public PerformanceController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/api/performance")
    public List<Performance> getPerformance() {

        return jdbcTemplate.query(
                "SELECT * FROM Performance",
                (rs, rowNum) -> {

                    Performance p = new Performance();

                    p.setVendorId(rs.getString("VendorID"));
                    p.setDeliveryRate(rs.getInt("DeliveryRate"));
                    p.setQualityScore(rs.getInt("QualityScore"));
                    p.setSlaCompliance(rs.getInt("SLACompliance"));
                    p.setLateDeliveries(rs.getInt("LateDeliveries"));

                    return p;
                });
    }
}