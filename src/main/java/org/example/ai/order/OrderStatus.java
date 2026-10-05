package org.example.ai.order;

public record OrderStatus(
        String orderId,
        String status,
        String expectedDelivery
) {
}