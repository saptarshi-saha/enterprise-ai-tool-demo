package org.example.ai.support;

import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/support")
public class SupportController {

    private final SupportService supportService;

    public SupportController(SupportService supportService) {
        this.supportService = supportService;
    }

    @PostMapping("/tickets")
    public SupportTicket createTicket(
            @Validated @RequestBody CreateTicketRequest request) {

        return supportService.createTicket(
                request.customerId(),
                request.description()
        );
    }

    public record CreateTicketRequest(
            @NonNull String customerId,
            @NonNull String description
    ) {
    }
}