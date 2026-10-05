package org.example.ai.order;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    public List<Order> getOrders(String customerId) {

        return List.of(
                new Order("1001", customerId, "Laptop"),
                new Order("1002", customerId, "Monitor"),
                new Order("1003", customerId, "Keyboard")
        );
    }

    public OrderStatus getOrderStatus(String orderId) {

        return switch (orderId) {

            case "1001" ->
                    new OrderStatus(
                            "1001",
                            "DELIVERED",
                            "2026-09-20"
                    );

            case "1002" ->
                    new OrderStatus(
                            "1002",
                            "DELAYED",
                            "2026-10-08"
                    );

            case "1003" ->
                    new OrderStatus(
                            "1003",
                            "PROCESSING",
                            "2026-10-10"
                    );

            default ->
                    new OrderStatus(
                            orderId,
                            "UNKNOWN",
                            null
                    );
        };
    }
}