package com.psiddhi.ivms.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.psiddhi.ivms.model.Supplier;
import com.psiddhi.ivms.repository.VendorRepository;

@Component
public class SupplierProcessor implements Processor {

    private final JdbcTemplate jdbcTemplate;

    public SupplierProcessor(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void process(Exchange exchange) throws Exception {

        String line = exchange.getIn().getBody(String.class);

        String[] columns = line.split(",");

        Supplier supplier = new Supplier();

        supplier.setVendorId(columns[0].trim());
        supplier.setVendorName(columns[1].trim());
        supplier.setCategory(columns[2].trim());
        supplier.setCountry(columns[3].trim());
        supplier.setSoleSourceFlag(columns[4].trim());
        supplier.setRiskCategory(columns[5].trim());

        VendorRepository.suppliers.put(
                supplier.getVendorId(),
                supplier);

        jdbcTemplate.update(
                """
                INSERT INTO Supplier
                VALUES (?, ?, ?, ?, ?, ?)
                """,
                supplier.getVendorId(),
                supplier.getVendorName(),
                supplier.getCategory(),
                supplier.getCountry(),
                supplier.getSoleSourceFlag(),
                supplier.getRiskCategory()
        );

        System.out.println(
                "Inserted Supplier into Azure SQL : "
                        + supplier.getVendorId());

        exchange.getIn().setBody(supplier);
    }
}