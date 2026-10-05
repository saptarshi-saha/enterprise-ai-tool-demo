package org.example.ai.order;

public record Order(
        String orderId,
        String customerId,
        String product
) {
}