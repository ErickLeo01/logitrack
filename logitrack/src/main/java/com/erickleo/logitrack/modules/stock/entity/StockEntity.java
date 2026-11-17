package com.erickleo.logitrack.modules.stock.entity;

import com.erickleo.logitrack.modules.product.entity.ProductEntity;
import com.erickleo.logitrack.modules.warehouse.entity.WarehouseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
// Representa a tabela "stock" com uma restrição de unicidade para a combinação de "warehouse_id" e "product_id".
@Table(name = "stock", uniqueConstraints = @UniqueConstraint(columnNames = {"warehouse_id", "product_id"}))
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull(message = "Informe a quantidade do estoque.")
    @PositiveOrZero(message = "A quantidade do estoque não pode ser negativa.")
    private Integer quantity;

    @NotNull(message = "Informe a quantidade reservada do estoque.")
    @PositiveOrZero(message = "A quantidade reservada do estoque não pode ser negativa.")
    private Integer quantityReserved;

    @NotNull(message = "Informe a quantidade mínima do estoque.")
    @PositiveOrZero(message = "A quantidade mínima do estoque não pode ser negativa.")
    private Integer minimumQuantity;

    @Version
    private Long version;

    @NotNull(message = "Informe o armazém do estoque.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id", nullable = false)
    private WarehouseEntity warehouse;

    @ManyToOne(fetch = FetchType.LAZY)  // Define quando os dados relacionados serão carregados do banco de dados.
    @JoinColumn(name = "product_id", nullable = false)    // LAZY significa carregamento sob demanda.
    @NotNull(message = "Informe o produto do estoque.")
    private ProductEntity product;
}
