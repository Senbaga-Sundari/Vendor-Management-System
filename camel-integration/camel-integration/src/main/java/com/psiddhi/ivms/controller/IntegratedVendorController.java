package com.psiddhi.ivms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntegratedVendorController {

    private final JdbcTemplate jdbcTemplate;

    public IntegratedVendorController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/api/vendor")
    public List<Map<String,Object>> getIntegratedVendors() {

        String sql = """
                SELECT
                    s.*,
                    f.InvoiceAmount,
                    f.PaymentDelay,
                    f.OutstandingAmount,
                    f.InvoiceCount,
                    p.DeliveryRate,
                    p.QualityScore,
                    p.SLACompliance,
                    p.LateDeliveries,
                    c.ContractExpiry,
                    c.ContractValue,
                    c.ContractStatus
                FROM Supplier s
                LEFT JOIN Finance f
                    ON s.VendorID = f.VendorID
                LEFT JOIN Performance p
                    ON s.VendorID = p.VendorID
                LEFT JOIN Contracts c
                    ON s.VendorID = c.VendorID
                """;

        return jdbcTemplate.queryForList(sql);
    }
}
