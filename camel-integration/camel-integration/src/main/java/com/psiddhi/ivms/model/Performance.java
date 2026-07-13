package com.psiddhi.ivms.model;

public class Performance {

    private String vendorId;
    private int deliveryRate;
    private int qualityScore;
    private int slaCompliance;
    private int lateDeliveries;

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public int getDeliveryRate() {
        return deliveryRate;
    }

    public void setDeliveryRate(int deliveryRate) {
        this.deliveryRate = deliveryRate;
    }

    public int getQualityScore() {
        return qualityScore;
    }

    public void setQualityScore(int qualityScore) {
        this.qualityScore = qualityScore;
    }

    public int getSlaCompliance() {
        return slaCompliance;
    }

    public void setSlaCompliance(int slaCompliance) {
        this.slaCompliance = slaCompliance;
    }

    public int getLateDeliveries() {
        return lateDeliveries;
    }

    public void setLateDeliveries(int lateDeliveries) {
        this.lateDeliveries = lateDeliveries;
    }

    @Override
    public String toString() {
        return "Performance{" +
                "vendorId='" + vendorId + '\'' +
                ", deliveryRate=" + deliveryRate +
                ", qualityScore=" + qualityScore +
                ", slaCompliance=" + slaCompliance +
                ", lateDeliveries=" + lateDeliveries +
                '}';
    }
}
