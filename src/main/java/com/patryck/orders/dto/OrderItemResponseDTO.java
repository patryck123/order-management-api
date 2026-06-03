package com.patryck.orders.dto;

import com.patryck.orders.entity.OrderItem;

import java.math.BigDecimal;

public record OrderItemResponseDTO(
    Long id,
    String productName,
    String productCode,
    int quantity,
    BigDecimal unitPrice,
    BigDecimal subtotal
) {
    public static OrderItemResponseDTO from(OrderItem item) {
        return new OrderItemResponseDTO(
            item.getId(),
            item.getProductName(),
            item.getProductCode(),
            item.getQuantity(),
            item.getUnitPrice(),
            item.getUnitPrice().multiply(BigDecimal.valueOf(item.getQuantity()))
        );
    }
}
