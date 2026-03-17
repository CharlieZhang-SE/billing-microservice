package com.billing.model;

import java.util.List;

public class Policy {
    private int policyId;
    private List<Integer> premiumSchedule;
    private boolean delinquent;

    // Constructors, getters, and setters
    public Policy(int policyId, List<Integer> premiumSchedule, boolean delinquent) {
        this.policyId = policyId;
        this.premiumSchedule = premiumSchedule;
        this.delinquent = delinquent;
    }

    public int getPolicyId() {
        return policyId;
    }

    public void setPolicyId(int policyId) {
        this.policyId = policyId;
    }

    public List<Integer> getPremiumSchedule() {
        return premiumSchedule;
    }

    public void setPremiumSchedule(List<Integer> premiumSchedule) {
        this.premiumSchedule = premiumSchedule;
    }

    public boolean isDelinquent() {
        return delinquent;
    }

    public void setDelinquent(boolean delinquent) {
        this.delinquent = delinquent;
    }
}