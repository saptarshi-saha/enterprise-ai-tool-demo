package org.example.ai.tool;

import org.example.ai.order.Order;
import org.example.ai.order.OrderService;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerTools {

    private final OrderService orderService;

    public CustomerTools(OrderService orderService) {
        this.orderService = orderService;
    }

    @Tool(
            name = "get_orders",
            description = "Get all orders belonging to a customer"
    )
    public List<Order> getOrders(
            @ToolParam(
                    description = "The unique customer ID"
            )
            String customerId) {
        return orderService.getOrders(customerId);
    }
}