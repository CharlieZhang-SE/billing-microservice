package com.billing.service;

import com.billing.model.Payment;
import com.billing.model.Policy;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BillingService {

    // Simulated in-memory data
    private final Map<Integer, Policy> policies = new HashMap<>();
    private final List<Payment> payments = new ArrayList<>();
    private final Map<Integer, Boolean> retryStatus = new HashMap<>();

    public BillingService() {
        policies.put(101, new Policy(101, Arrays.asList(100, 100, 100), false));
        policies.put(102, new Policy(102, Arrays.asList(200, 200, 200), true));
        policies.put(103, new Policy(103, Arrays.asList(300, 300, 300), false));
    }

    // Retrieve the premium schedule for a policy
    public Policy getPremiumSchedule(int policyId) {
        return policies.get(policyId);
    }

    // Record a payment attempt
    public Payment recordPaymentAttempt(int policyId, Payment payment) {
        payments.add(payment);
        Policy policy = policies.get(policyId);
        if ("failure".equals(payment.getStatus())) {
            policy.setDelinquent(true);
        } else {
            policy.setDelinquent(false);
        }
        return payment;
    }

    // Get a list of delinquent policies
    public List<Integer> getDelinquentPolicies() {
        List<Integer> delinquentPolicies = new ArrayList<>();
        for (Map.Entry<Integer, Policy> entry : policies.entrySet()) {
            if (entry.getValue().isDelinquent()) {
                delinquentPolicies.add(entry.getKey());
            }
        }
        return delinquentPolicies;
    }

    // Trigger retry for a failed payment
    public boolean triggerRetry(int policyId) {
        Policy policy = policies.get(policyId);
        if (policy != null && policy.isDelinquent() && !retryStatus.getOrDefault(policyId, false)) {
            retryStatus.put(policyId, true);  // Mark retry attempt
            return true; // Simulate retry success
        }
        return false; // Retry failed
    }
}