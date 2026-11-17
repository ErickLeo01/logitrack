package com.erickleo.logitrack.modules.delivery.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "delivery_person")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeliveryPersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Informe o nome do entregador.")
    private String name;

    @NotBlank(message = "Informe o e-mail do entregador.")
    @Email(message = "Informe um e-mail válido.")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Informe o telefone do entregador.")
    private String phone;

    @NotBlank(message = "Informe o documento do entregador.")
    @Column(unique = true)
    private String document;

    @NotNull(message = "Informe o status do entregador.")
    private Boolean active;

    @NotNull(message = "Informe a data de criação do entregador.")
    private LocalDateTime creationDate;
}