package com.billing.controller;

import com.billing.model.Payment;
import com.billing.model.Policy;
import com.billing.model.Response;
import com.billing.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/policies")
public class BillingController {

    @Autowired
    private BillingService billingService;

    // Get Premium Schedule
    @GetMapping("/{policyId}/schedule")
    public Response<Policy> getPremiumSchedule(@PathVariable int policyId) {
        Policy policy = billingService.getPremiumSchedule(policyId);
        if (policy != null) {
            return new Response<>("Premium schedule retrieved successfully", policy);
        } else {
            return new Response<>("Policy not found");
        }
    }

    // Record Payment Attempt
    @PostMapping("/{policyId}/payment")
    public Response<Payment> recordPaymentAttempt(@PathVariable int policyId, @RequestBody Payment payment) {
        Payment recordedPayment = billingService.recordPaymentAttempt(policyId, payment);
        if (recordedPayment != null) {
            return new Response<>("Payment recorded successfully", recordedPayment);
        } else {
            return new Response<>("Payment attempt failed");
        }
    }

    // Get Delinquent Policies
    @GetMapping("/delinquent")
    public Response<List<Integer>> getDelinquentPolicies() {
        List<Integer> delinquentPolicies = billingService.getDelinquentPolicies();
        return new Response<>("Delinquent policies retrieved successfully", delinquentPolicies);
    }

    // Trigger Retry for Failed Payment
    @PostMapping("/{policyId}/retry")
    public Response<String> triggerRetry(@PathVariable int policyId) {
        boolean retryStatus = billingService.triggerRetry(policyId);
        if (retryStatus) {
            return new Response<>("Retry triggered", "Retry successfully initiated for policy " + policyId);
        } else {
            return new Response<>("Retry failed");
        }
    }
}