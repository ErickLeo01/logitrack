package com.erickleo.logitrack.modules.user.dto;

import com.erickleo.logitrack.modules.user.enumm.UserRoleEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDTO(

        @NotBlank(message = "Informe o nome do usuário.")
        String name,

        @NotBlank(message = "Informe o e-mail do usuário.")
        @Email(message = "Informe um e-mail válido.")
        String email,

        @NotBlank(message = "Informe a senha do usuário.")
        String password,

        @NotNull(message = "Informe o tipo do usuário.")
        UserRoleEnum userRole
) {
}
