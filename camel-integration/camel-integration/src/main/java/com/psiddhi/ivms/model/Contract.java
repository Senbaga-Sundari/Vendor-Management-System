package com.psiddhi.ivms.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Contract {

    private String vendorId;
    private String contractExpiry;
    private double contractValue;

    @JsonProperty("ContractStatus")
    private String contractStatus;

    public Contract() {
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getContractExpiry() {
        return contractExpiry;
    }

    public void setContractExpiry(String contractExpiry) {
        this.contractExpiry = contractExpiry;
    }

    public double getContractValue() {
        return contractValue;
    }

    public void setContractValue(double contractValue) {
        this.contractValue = contractValue;
    }

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "vendorId='" + vendorId + '\'' +
                ", contractExpiry='" + contractExpiry + '\'' +
                ", contractValue=" + contractValue +
                ", contractStatus='" + contractStatus + '\'' +
                '}';
    }
}