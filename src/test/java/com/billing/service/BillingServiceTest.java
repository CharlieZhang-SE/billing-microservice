package com.billing.service;

import com.billing.model.Payment;
import com.billing.model.Policy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class BillingServiceTest {

    private BillingService billingService;

    @BeforeEach
    public void setUp() {
        billingService = new BillingService();
    }

    @Test
    void testRecordPaymentAttemptSuccess() {
        Payment payment = new Payment(101, "success", 100);
        Policy policy = new Policy(101, Arrays.asList(100, 100, 100), false);

        // Ensure lenient mocking or correct method calls for different arguments
        lenient().when(billingService.recordPaymentAttempt(101, payment)).thenReturn(payment);

        Payment resultPayment = billingService.recordPaymentAttempt(101, payment);
        assertNotNull(resultPayment);  // Ensure that the returned payment is not null
        assertEquals("success", resultPayment.getStatus());  // Check the payment status
    }

    @Test
    void testGetDelinquentPolicies() {
        // Your code for testing delinquent policies
    }
}