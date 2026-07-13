package com.psiddhi.ivms.model;

public class Supplier {

    private String vendorId;
    private String vendorName;
    private String category;
    private String country;
    private String soleSourceFlag;
    private String riskCategory;

    // Default Constructor
    public Supplier() {
    }

    // Getters and Setters

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSoleSourceFlag() {
        return soleSourceFlag;
    }

    public void setSoleSourceFlag(String soleSourceFlag) {
        this.soleSourceFlag = soleSourceFlag;
    }

    public String getRiskCategory() {
        return riskCategory;
    }

    public void setRiskCategory(String riskCategory) {
        this.riskCategory = riskCategory;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "vendorId='" + vendorId + '\'' +
                ", vendorName='" + vendorName + '\'' +
                ", category='" + category + '\'' +
                ", country='" + country + '\'' +
                ", soleSourceFlag='" + soleSourceFlag + '\'' +
                ", riskCategory='" + riskCategory + '\'' +
                '}';
    }
}
