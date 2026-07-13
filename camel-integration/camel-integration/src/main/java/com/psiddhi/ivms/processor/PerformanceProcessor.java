package com.psiddhi.ivms.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.psiddhi.ivms.model.Performance;
import com.psiddhi.ivms.repository.VendorRepository;

@Component
public class PerformanceProcessor implements Processor {

    private final JdbcTemplate jdbcTemplate;

    public PerformanceProcessor(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void process(Exchange exchange) throws Exception {

        String line = exchange.getIn().getBody(String.class);

        String[] columns = line.split(",");

        Performance performance = new Performance();

        performance.setVendorId(columns[0].trim());
        performance.setDeliveryRate(Integer.parseInt(columns[1].trim()));
        performance.setQualityScore(Integer.parseInt(columns[2].trim()));
        performance.setSlaCompliance(Integer.parseInt(columns[3].trim()));
        performance.setLateDeliveries(Integer.parseInt(columns[4].trim()));

        VendorRepository.performances.put(
                performance.getVendorId(),
                performance);

        jdbcTemplate.update(
                """
                INSERT INTO Performance
                VALUES (?, ?, ?, ?, ?)
                """,
                performance.getVendorId(),
                performance.getDeliveryRate(),
                performance.getQualityScore(),
                performance.getSlaCompliance(),
                performance.getLateDeliveries()
        );

        System.out.println(
                "Inserted Performance into Azure SQL : "
                        + performance.getVendorId());

        exchange.getIn().setBody(performance);
    }
}