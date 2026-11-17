package com.erickleo.logitrack.modules.product.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Informe o nome do produto.")
    private String name;

    @NotBlank(message = "Informe a descrição do produto.")
    private String description;

    @NotBlank(message = "Informe a categoria do produto.")
    private String category;

    @NotBlank(message = "Informe a marca do produto.")
    private String brand;

    @NotBlank(message = "Informe o código do produto.")
    @Column(unique = true)
    private String productCode;

    @NotNull(message = "Informe o preço do produto.")
    @Positive(message = "O preço deve ser maior que zero.")
    private BigDecimal price;

    @NotNull(message = "Informe o status do produto.")
    private Boolean status;
}
