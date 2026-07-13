package com.psiddhi.ivms.service;

import java.util.ArrayList;
import java.util.List;

import com.psiddhi.ivms.model.Contract;
import com.psiddhi.ivms.model.Finance;
import com.psiddhi.ivms.model.Performance;
import com.psiddhi.ivms.model.Supplier;
import com.psiddhi.ivms.model.VendorProfile;
import com.psiddhi.ivms.repository.VendorRepository;

public class VendorProfileService {

    public List<VendorProfile> buildProfiles() {

        List<VendorProfile> profiles = new ArrayList<>();

        for (String vendorId : VendorRepository.suppliers.keySet()) {

            Supplier supplier =
                    VendorRepository.suppliers.get(vendorId);

            Finance finance =
                    VendorRepository.finances.get(vendorId);

            Performance performance =
                    VendorRepository.performances.get(vendorId);

            Contract contract =
                    VendorRepository.contracts.get(vendorId);

            VendorProfile profile = new VendorProfile();

            profile.setSupplier(supplier);
            profile.setFinance(finance);
            profile.setPerformance(performance);
            profile.setContract(contract);

            profiles.add(profile);
        }

        return profiles;
    }
}