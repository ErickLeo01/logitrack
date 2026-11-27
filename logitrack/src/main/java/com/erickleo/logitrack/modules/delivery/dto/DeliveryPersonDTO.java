package com.erickleo.logitrack.modules.delivery.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DeliveryPersonDTO(

        @NotBlank(message = "Informe o nome do entregador.")
        String name,

        @NotBlank(message = "Informe o e-mail do entregador.")
        @Email(message = "Informe um e-mail válido.")
        String email,

        @NotBlank(message = "Informe o telefone do entregador.")
        String phone,

        @NotBlank(message = "Informe o documento do entregador.")
        String document,

        @NotNull(message = "Informe a data de criação do entregador.")
        LocalDateTime creationDate
) {
}
