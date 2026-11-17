package com.erickleo.logitrack.modules.stock.entity;

import com.erickleo.logitrack.modules.product.entity.ProductEntity;
import com.erickleo.logitrack.modules.stock.enumm.MovementTypeEnum;
import com.erickleo.logitrack.modules.user.entity.UserEntity;
import com.erickleo.logitrack.modules.warehouse.entity.WarehouseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "stock_movement")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StockMovementEntity {   // Registra todas as movimentações realizadas nos depósitos.

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull(message = "Informe o tipo da movimentação.")
    @Enumerated(EnumType.STRING)
    private MovementTypeEnum type;

    @NotBlank(message = "Informe a descrição da movimentação.")
    private String description;

    @NotNull(message = "Informe a data da movimentação.")
    private LocalDateTime momentDate;

    @NotNull(message = "Informe a quantidade da movimentação.")
    @Positive(message = "A quantidade deve ser maior que 0 (zero).")
    private Integer quantity;

    @NotNull(message = "Informe o produto da movimentação.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_warehouse_id")
    private WarehouseEntity sourceWarehouse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_warehouse_id")
    private WarehouseEntity destinationWarehouse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @NotNull(message = "Informe o usuário da movimentação..")
    private UserEntity user;
}
