package org.example.ai.order;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getOrders(
            @RequestParam String customerId) {

        return orderService.getOrders(customerId);
    }

    @GetMapping("/{orderId}/status")
    public OrderStatus getOrderStatus(
            @PathVariable String orderId) {

        return orderService.getOrderStatus(orderId);
    }
}