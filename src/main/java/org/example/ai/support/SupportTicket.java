package org.example.ai.support;

public record SupportTicket(
        String ticketId,
        String customerId,
        String description,
        String status
) {
}