package com.billing.controller;

import com.billing.model.Payment;
import com.billing.service.BillingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(MockitoExtension.class)
public class BillingControllerTest {

    @Mock
    private BillingService billingService;

    @InjectMocks
    private BillingController billingController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(billingController).build();
    }

    @Test
    void testRecordPaymentAttempt() throws Exception {
        Payment payment = new Payment(101, "success", 100);

        // Use ArgumentMatchers.any() to match any Payment object
        doReturn(payment).when(billingService).recordPaymentAttempt(any(Integer.class), any(Payment.class));

        mockMvc.perform(post("/policies/101/payment")
                        .contentType("application/json")
                        .content("{\"status\": \"success\", \"amount\": 100}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Payment recorded successfully"))  // Assert the message
                .andExpect(jsonPath("$.data.amount").value(100));  // Assert the amount
    }
}