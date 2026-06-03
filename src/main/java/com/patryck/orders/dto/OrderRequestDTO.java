package com.patryck.orders.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record OrderRequestDTO(
    @NotBlank(message = "Nome do cliente é obrigatório")
    String customerName,

    @NotBlank @Email(message = "E-mail inválido")
    String customerEmail,

    @NotEmpty(message = "Pedido deve ter pelo menos 1 item")
    @Valid
    List<OrderItemRequestDTO> items
) {}
