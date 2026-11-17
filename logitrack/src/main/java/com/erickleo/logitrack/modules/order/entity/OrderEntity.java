package com.erickleo.logitrack.modules.order.entity;

import com.erickleo.logitrack.modules.order.enumm.OrderStatusEnum;
import com.erickleo.logitrack.modules.user.entity.UserEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderEntity {  // Representa os pedidos realizados pelos clientes.

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull(message = "Informe a data do pedido.")
    private LocalDateTime orderDate;

    @NotNull(message = "Informe a data de atualização do pedido.")
    private LocalDateTime updatedAt;

    @PositiveOrZero(message = "O valor não pode ser negativo.")
    @NotNull(message = "Informe o valor total do pedido.")
    private BigDecimal totalAmount;

    @NotBlank(message = "Informe o endereço de entrega.")
    private String deliveryAddress;

    @NotNull(message = "Informe o status do pedido.")
    @Enumerated(EnumType.STRING)
    private OrderStatusEnum status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "Informe o usuário do pedido.")
    private UserEntity user;
}