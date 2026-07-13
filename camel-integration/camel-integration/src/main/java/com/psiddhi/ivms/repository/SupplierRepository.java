package com.psiddhi.ivms.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.psiddhi.ivms.model.Supplier;

@Repository
public class SupplierRepository {

    private final JdbcTemplate jdbcTemplate;

    public SupplierRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Supplier> getAllSuppliers() {

        return jdbcTemplate.query(
                "SELECT * FROM Supplier",
                (rs, rowNum) -> {

                    Supplier supplier = new Supplier();

                    supplier.setVendorId(rs.getString("VendorID"));
                    supplier.setVendorName(rs.getString("VendorName"));
                    supplier.setCategory(rs.getString("Category"));
                    supplier.setCountry(rs.getString("Country"));
                    supplier.setSoleSourceFlag(rs.getString("SoleSourceFlag"));
                    supplier.setRiskCategory(rs.getString("RiskCategory"));

                    return supplier;
                });
    }
}
