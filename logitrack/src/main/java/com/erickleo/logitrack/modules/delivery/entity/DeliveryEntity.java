package com.erickleo.logitrack.modules.delivery.entity;

import com.erickleo.logitrack.modules.delivery.enumm.DeliveryStatusEnum;
import com.erickleo.logitrack.modules.order.entity.OrderEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "delivery")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeliveryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Informe o código de rastreamento.")
    @Column(unique = true)
    private String trackingCode;

    @NotNull(message = "Informe o status da entrega.")
    @Enumerated(EnumType.STRING) // Armazena o nome do enum no banco de dados.
    private DeliveryStatusEnum status;

    private LocalDateTime shippingDate;  // Data de envio da entrega.

    @NotNull(message = "Informe a data estimativa da entrega.")
    private LocalDateTime estimatedDeliveryDate;

    private LocalDateTime actualDeliveryDate;

    @NotBlank(message = "Informe o endereço de destino.")
    private String destinationAddress;

    // Representa o pedido que está sendo transportado ou entregue.
    @NotNull(message = "Informe o pedido.")
    @OneToOne(fetch = FetchType.LAZY) // Carrega o pedido apenas quando necessário.
    @JoinColumn(name = "order_id", nullable = false, unique = true)// Garante que cada entrega esteja associada a um único pedido.
    private OrderEntity order;

    // Entregador
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_person_id")
    private DeliveryPersonEntity deliveryPerson;
}