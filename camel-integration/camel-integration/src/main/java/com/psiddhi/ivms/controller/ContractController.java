package com.psiddhi.ivms.controller;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psiddhi.ivms.model.Contract;

@RestController
public class ContractController {

    private final JdbcTemplate jdbcTemplate;

    public ContractController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/api/contracts")
    public List<Contract> getContracts() {

        return jdbcTemplate.query(
                "SELECT * FROM Contracts",
                (rs, rowNum) -> {

                    Contract contract = new Contract();

                    contract.setVendorId(rs.getString("VendorID"));
                    contract.setContractExpiry(
                          rs.getString("ContractExpiry"));

                    contract.setContractValue(
                            rs.getDouble("ContractValue"));

                    contract.setContractStatus(
                            rs.getString("ContractStatus"));

                    return contract;
                });
    }
}