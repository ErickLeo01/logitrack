package com.erickleo.logitrack.modules.stock.repository;

import com.erickleo.logitrack.modules.stock.entity.StockMovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StockMovementRepository extends JpaRepository<StockMovementEntity, UUID> {
}
