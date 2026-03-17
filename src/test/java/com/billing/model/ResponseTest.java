package com.billing.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ResponseTest {

    @Test
    void testSuccessResponse() {
        Response<Payment> response = new Response<>("Payment successful", new Payment(101, "success", 100));
        assertEquals("Payment successful", response.getMessage());
        assertNotNull(response.getData());
    }

    @Test
    void testErrorResponse() {
        Response<Object> response = new Response<>("Payment failed");
        assertEquals("Payment failed", response.getError());
        assertNull(response.getData());
    }
}