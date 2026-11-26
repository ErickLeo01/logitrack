package com.erickleo.logitrack.modules.warehouse.dto;

import jakarta.validation.constraints.NotBlank;

public record WarehouseDTO(

        @NotBlank(message = "Informe o nome do armazém.")
        String name,

        @NotBlank(message = "Informe o endereço do armazém.")
        String address,

        @NotBlank(message = "Informe o país do armazem.")
        String country,

        @NotBlank(message = "Informe a cidade do armazem.")
        String city,

        @NotBlank(message = "Informe o estado do armazem.")
        String state
) {
}
