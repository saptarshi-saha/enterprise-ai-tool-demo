package org.example.ai.support;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SupportService {

    public SupportTicket createTicket(
            String customerId,
            String description) {

        return new SupportTicket(
                UUID.randomUUID().toString(),
                customerId,
                description,
                "OPEN"
        );
    }
}