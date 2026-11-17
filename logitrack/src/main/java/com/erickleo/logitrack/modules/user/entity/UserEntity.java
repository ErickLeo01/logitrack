package com.erickleo.logitrack.modules.user.entity;

import com.erickleo.logitrack.modules.user.enumm.UserRoleEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Informe o nome do usuário.")
    private String name;

    @NotBlank(message = "Informe o e-mail do usuário.")
    @Email(message = "Informe um e-mail válido.")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Informe a senha do usuário.")
    private String password;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Informe o tipo do usuário.")
    private UserRoleEnum userRole;
}
