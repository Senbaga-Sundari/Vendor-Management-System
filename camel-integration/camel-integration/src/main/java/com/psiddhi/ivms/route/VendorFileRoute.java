package com.psiddhi.ivms.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import com.psiddhi.ivms.model.Contract;
import com.psiddhi.ivms.processor.ContractProcessor;
import com.psiddhi.ivms.processor.FinanceProcessor;
import com.psiddhi.ivms.processor.PerformanceProcessor;
import com.psiddhi.ivms.processor.SupplierProcessor;

@Component
public class VendorFileRoute extends RouteBuilder {

    private final SupplierProcessor supplierProcessor;
    private final FinanceProcessor financeProcessor;
    private final PerformanceProcessor performanceProcessor;
    private final ContractProcessor contractProcessor;

    public VendorFileRoute(
            SupplierProcessor supplierProcessor,
            FinanceProcessor financeProcessor,
            PerformanceProcessor performanceProcessor,
            ContractProcessor contractProcessor) {

        this.supplierProcessor = supplierProcessor;
        this.financeProcessor = financeProcessor;
        this.performanceProcessor = performanceProcessor;
        this.contractProcessor = contractProcessor;
    }

    @Override
    public void configure() throws Exception {

        // Suppliers
        from("file:input?fileName=enterprise_suppliers.csv&move=processed")
                .split(body().tokenize("\n"))
                .filter(simple("${body} not contains 'VendorID'"))
                .process(supplierProcessor);

        // Finance
        from("file:input?fileName=enterprise_finance.csv&move=processed")
                .split(body().tokenize("\n"))
                .filter(simple("${body} not contains 'VendorID'"))
                .process(financeProcessor);

        // Performance
        from("file:input?fileName=enterprise_performance.csv&move=processed")
                .split(body().tokenize("\n"))
                .filter(simple("${body} not contains 'VendorID'"))
                .process(performanceProcessor);

        // Contracts
        from("file:input?fileName=enterprise_contracts.json&move=processed")
                .unmarshal()
                .json(JsonLibrary.Jackson, Contract[].class)
                .split(body())
                .process(contractProcessor);
    }
}
