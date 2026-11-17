package com.erickleo.logitrack.modules.order.entity;

import com.erickleo.logitrack.modules.product.entity.ProductEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "order_item")
@AllArgsConstructor
@NoArgsConstructor
@Data
// Representa um item de pedido, que é uma associação entre um pedido e um produto, contendo informações sobre a
// quantidade e o preço unitário do produto no pedido.
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull(message = "Informe a quantidade do item do pedido.")
    @Positive(message = "A quantidade do item do pedido deve ser maior que zero.")
    private Integer quantity;

    @NotNull(message = "Informe o preço unitário do item do pedido.")
    @Positive(message = "O preço unitário do item do pedido deve ser maior que zero.")
    private BigDecimal unitPrice;

    @NotNull(message = "Informe o pedido do item.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private OrderEntity order; // Pedido.

    @NotNull(message = "Informe o produto do item do pedido.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;
}
