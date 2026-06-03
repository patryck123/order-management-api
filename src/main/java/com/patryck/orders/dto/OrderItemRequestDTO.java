package com.patryck.orders.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record OrderItemRequestDTO(
    @NotBlank(message = "Nome do produto é obrigatório")
    String productName,

    @NotBlank(message = "Código do produto é obrigatório")
    String productCode,

    @Min(value = 1, message = "Quantidade mínima é 1")
    int quantity,

    @NotNull @Positive(message = "Preço deve ser positivo")
    BigDecimal unitPrice
) {}
