package com.psiddhi.ivms.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.psiddhi.ivms.model.VendorProfile;
import com.psiddhi.ivms.service.VendorProfileService;

@Component
public class VendorRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        VendorProfileService service = new VendorProfileService();

        for (VendorProfile profile : service.buildProfiles()) {

            System.out.println("--------------------------------");

            System.out.println(profile.getSupplier().getVendorId());

            System.out.println(profile.getSupplier().getVendorName());

            System.out.println(profile.getFinance().getInvoiceAmount());

            System.out.println(profile.getPerformance().getDeliveryRate());

            System.out.println(profile.getContract().getContractStatus());

        }

    }

}
