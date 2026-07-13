package com.psiddhi.ivms.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.psiddhi.ivms.model.Contract;
import com.psiddhi.ivms.repository.VendorRepository;

@Component
public class ContractProcessor implements Processor {

    private final JdbcTemplate jdbcTemplate;

    public ContractProcessor(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void process(Exchange exchange) throws Exception {

        Contract contract =
                exchange.getIn().getBody(Contract.class);

        if (contract != null) {

            VendorRepository.contracts.put(
                    contract.getVendorId(),
                    contract);

            jdbcTemplate.update(
                    """
                    INSERT INTO Contracts
                    VALUES (?, ?, ?, ?)
                    """,
                    contract.getVendorId(),
                    contract.getContractExpiry(),
                    contract.getContractValue(),
                    contract.getContractStatus()
            );

            System.out.println(
                    "Inserted Contract into Azure SQL : "
                            + contract.getVendorId());

            exchange.getIn().setBody(contract);
        }
    }
}