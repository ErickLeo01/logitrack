package com.erickleo.logitrack.modules.warehouse.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record WarenhouseDTO(

        @NotBlank(message = "Informe o nome do armazém.")
        String name,

        @NotBlank(message = "Informe o endereço do armazém.")
        String address,

        @NotBlank(message = "Informe o país do armazem.")
        String country,

        @NotBlank(message = "Informe a cidade do armazem.")
        String city,

        @NotBlank(message = "Informe o estado do armazem.")
        String state,

        @NotNull(message = "Informe o status do armazem.")
        Boolean status,

        @NotNull(message = "Informe a data de criação do armazem.")
        LocalDateTime creationDate
) {
}
