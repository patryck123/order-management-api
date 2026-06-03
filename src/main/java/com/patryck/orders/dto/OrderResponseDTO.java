package com.patryck.orders.dto;

import com.patryck.orders.entity.Order;
import com.patryck.orders.entity.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrderResponseDTO(
    Long id,
    String customerName,
    String customerEmail,
    OrderStatus status,
    BigDecimal totalAmount,
    List<OrderItemResponseDTO> items,
    LocalDateTime createdAt
) {
    public static OrderResponseDTO from(Order order) {
        return new OrderResponseDTO(
            order.getId(),
            order.getCustomerName(),
            order.getCustomerEmail(),
            order.getStatus(),
            order.getTotalAmount(),
            order.getItems().stream().map(OrderItemResponseDTO::from).toList(),
            order.getCreatedAt()
        );
    }
}
