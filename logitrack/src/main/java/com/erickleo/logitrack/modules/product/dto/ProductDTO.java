package com.erickleo.logitrack.modules.product.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductDTO(

        @NotBlank(message = "O nome do produto não pode ser nulo.")
        String name,

        @NotBlank(message = "Informe a descrição do produto.")
        String description,

        @NotBlank(message = "Informe a categoria do produto.")
        String category,

        @NotBlank(message = "Informe a marca do produto.")
        String brand,

        @NotBlank(message = "Informe o código do produto.")
        String productCode,

        @NotNull(message = "Informe o preço do produto.")
        @Positive(message = "O preço deve ser maior que zero.")
        BigDecimal price
        ) {
}
