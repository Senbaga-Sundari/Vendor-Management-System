package com.psiddhi.ivms.controller;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psiddhi.ivms.model.Finance;

@RestController
public class FinanceController {

    private final JdbcTemplate jdbcTemplate;

    public FinanceController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/api/finance")
    public List<Finance> getFinance() {

        return jdbcTemplate.query(
                "SELECT * FROM Finance",
                (rs, rowNum) -> {

                    Finance finance = new Finance();

                    finance.setVendorId(rs.getString("VendorID"));
                    finance.setInvoiceAmount(rs.getDouble("InvoiceAmount"));
                    finance.setPaymentDelay(rs.getInt("PaymentDelay"));
                    finance.setOutstandingAmount(rs.getDouble("OutstandingAmount"));
                    finance.setInvoiceCount(rs.getInt("InvoiceCount"));

                    return finance;
                });
    }
}