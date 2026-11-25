package com.erickleo.logitrack.modules.stock.repository;

import com.erickleo.logitrack.modules.stock.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StockRepository extends JpaRepository<StockEntity, UUID> {

    Optional<StockEntity> findByProductIdAndWarehouseId(UUID productId, UUID warehouseId);

    List<StockEntity> findByWarehouseId(UUID warehouseId);
}
