package com.erickleo.logitrack.modules.warehouse.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "warehouses")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WarehouseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Informe o nome do armazém.")
    private String name;

    @NotBlank(message = "Informe o endereço do armazém.")
    private String address;

    @NotBlank(message = "Informe o país do armazem.")
    private String country;

    @NotBlank(message = "Informe a cidade do armazem.")
    private String city;

    @NotBlank(message = "Informe o estado do armazem.")
    private String state;

    @NotNull(message = "Informe o status do armazem.")
    private Boolean status;

    @NotNull(message = "Informe a data de criação do armazem.")
    private LocalDateTime creationDate;
}
