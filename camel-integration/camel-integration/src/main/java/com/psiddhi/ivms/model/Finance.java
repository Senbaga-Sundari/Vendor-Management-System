package com.psiddhi.ivms.model;

public class Finance {

    private String vendorId;
    private double invoiceAmount;
    private int paymentDelay;
    private double outstandingAmount;
    private int invoiceCount;

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public int getPaymentDelay() {
        return paymentDelay;
    }

    public void setPaymentDelay(int paymentDelay) {
        this.paymentDelay = paymentDelay;
    }

    public double getOutstandingAmount() {
        return outstandingAmount;
    }

    public void setOutstandingAmount(double outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
    }

    public int getInvoiceCount() {
        return invoiceCount;
    }

    public void setInvoiceCount(int invoiceCount) {
        this.invoiceCount = invoiceCount;
    }

    @Override
    public String toString() {
        return "Finance{" +
                "vendorId='" + vendorId + '\'' +
                ", invoiceAmount=" + invoiceAmount +
                ", paymentDelay=" + paymentDelay +
                ", outstandingAmount=" + outstandingAmount +
                ", invoiceCount=" + invoiceCount +
                '}';
    }
}