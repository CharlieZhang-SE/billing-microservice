package com.billing.model;

public class Payment {
    private int policyId;
    private String status;
    private int amount;

    // Default constructor for Jackson
    public Payment() {
    }
    
    // Constructors, getters, and setters
    public Payment(int policyId, String status, int amount) {
        this.policyId = policyId;
        this.status = status;
        this.amount = amount;
    }

    public int getPolicyId() {
        return policyId;
    }

    public void setPolicyId(int policyId) {
        this.policyId = policyId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}