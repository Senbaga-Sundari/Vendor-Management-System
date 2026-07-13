package com.psiddhi.ivms.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.psiddhi.ivms.model.Finance;
import com.psiddhi.ivms.repository.VendorRepository;

@Component
public class FinanceProcessor implements Processor {

    private final JdbcTemplate jdbcTemplate;

    public FinanceProcessor(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void process(Exchange exchange) throws Exception {

        String line = exchange.getIn().getBody(String.class);

        String[] columns = line.split(",");

        Finance finance = new Finance();

        finance.setVendorId(columns[0].trim());
        finance.setInvoiceAmount(Double.parseDouble(columns[1].trim()));
        finance.setPaymentDelay(Integer.parseInt(columns[2].trim()));
        finance.setOutstandingAmount(Double.parseDouble(columns[3].trim()));
        finance.setInvoiceCount(Integer.parseInt(columns[4].trim()));

        VendorRepository.finances.put(
                finance.getVendorId(),
                finance);

        jdbcTemplate.update(
                """
                INSERT INTO Finance
                VALUES (?, ?, ?, ?, ?)
                """,
                finance.getVendorId(),
                finance.getInvoiceAmount(),
                finance.getPaymentDelay(),
                finance.getOutstandingAmount(),
                finance.getInvoiceCount()
        );

        System.out.println(
                "Inserted Finance into Azure SQL : "
                        + finance.getVendorId());

        exchange.getIn().setBody(finance);
    }
}