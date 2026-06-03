package com.patryck.orders.service;

import com.patryck.orders.dto.OrderRequestDTO;
import com.patryck.orders.dto.OrderResponseDTO;
import com.patryck.orders.entity.Order;
import com.patryck.orders.entity.OrderItem;
import com.patryck.orders.entity.OrderStatus;
import com.patryck.orders.exception.OrderNotFoundException;
import com.patryck.orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public OrderResponseDTO createOrder(OrderRequestDTO dto) {
        Order order = Order.builder()
            .customerName(dto.customerName())
            .customerEmail(dto.customerEmail())
            .build();

        dto.items().forEach(itemDto -> {
            OrderItem item = OrderItem.builder()
                .productName(itemDto.productName())
                .productCode(itemDto.productCode())
                .quantity(itemDto.quantity())
                .unitPrice(itemDto.unitPrice())
                .order(order)
                .build();
            order.getItems().add(item);
        });

        order.recalculateTotal();
        return OrderResponseDTO.from(orderRepository.save(order));
    }

    @Transactional(readOnly = true)
    public List<OrderResponseDTO> findAll() {
        return orderRepository.findAll()
            .stream()
            .map(OrderResponseDTO::from)
            .toList();
    }

    @Transactional(readOnly = true)
    public OrderResponseDTO findById(Long id) {
        return orderRepository.findById(id)
            .map(OrderResponseDTO::from)
            .orElseThrow(() -> new OrderNotFoundException("Pedido não encontrado com id: " + id));
    }

    @Transactional(readOnly = true)
    public List<OrderResponseDTO> findByEmail(String email) {
        return orderRepository.findByCustomerEmail(email)
            .stream()
            .map(OrderResponseDTO::from)
            .toList();
    }

    @Transactional
    public OrderResponseDTO updateStatus(Long id, OrderStatus newStatus) {
        Order order = orderRepository.findById(id)
            .orElseThrow(() -> new OrderNotFoundException("Pedido não encontrado com id: " + id));
        order.setStatus(newStatus);
        return OrderResponseDTO.from(orderRepository.save(order));
    }

    @Transactional
    public void cancelOrder(Long id) {
        Order order = orderRepository.findById(id)
            .orElseThrow(() -> new OrderNotFoundException("Pedido não encontrado com id: " + id));
        order.setStatus(OrderStatus.CANCELLED);
        orderRepository.save(order);
    }
}
