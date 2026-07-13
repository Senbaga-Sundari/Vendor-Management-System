package com.psiddhi.ivms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.psiddhi.ivms.model.Finance;
import com.psiddhi.ivms.model.Performance;
import com.psiddhi.ivms.model.Supplier;
import com.psiddhi.ivms.model.VendorRisk;
import com.psiddhi.ivms.repository.VendorRepository;

@Service
public class RiskService {

    private final JdbcTemplate jdbcTemplate;

    public RiskService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<VendorRisk> calculateRisk() {

        List<VendorRisk> result = new ArrayList<>();

        // Remove previous risk results
        jdbcTemplate.update("DELETE FROM VendorRisk");

        for (Supplier supplier : VendorRepository.suppliers.values()) {

            Finance finance =
                    VendorRepository.finances.get(
                            supplier.getVendorId());

            Performance performance =
                    VendorRepository.performances.get(
                            supplier.getVendorId());

            int score = 0;

            // Supplier Risk
            if ("High".equalsIgnoreCase(
                    supplier.getRiskCategory())) {
                score += 40;
            }

            // Finance Risk
            if (finance != null &&
                    finance.getPaymentDelay() > 30) {
                score += 30;
            }

            // Performance Risk
            if (performance != null &&
                    performance.getDeliveryRate() < 80) {
                score += 30;
            }

            VendorRisk risk = new VendorRisk();

            risk.setVendorId(
                    supplier.getVendorId());

            risk.setVendorName(
                    supplier.getVendorName());

            risk.setRiskScore(score);

            if (score >= 70) {
                risk.setRiskLevel("HIGH");
            }
            else if (score >= 40) {
                risk.setRiskLevel("MEDIUM");
            }
            else {
                risk.setRiskLevel("LOW");
            }

            // Store in Azure SQL
            jdbcTemplate.update(
                    """
                    INSERT INTO VendorRisk
                    (VendorID, VendorName, RiskScore, RiskLevel)
                    VALUES (?, ?, ?, ?)
                    """,
                    risk.getVendorId(),
                    risk.getVendorName(),
                    risk.getRiskScore(),
                    risk.getRiskLevel()
            );

            System.out.println(
                    "Stored Risk : "
                            + risk.getVendorId()
                            + " -> "
                            + risk.getRiskLevel()
                            + " ("
                            + risk.getRiskScore()
                            + ")");

            result.add(risk);
        }

        return result;
    }
}