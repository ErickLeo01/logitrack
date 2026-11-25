package com.erickleo.logitrack.modules.warehouse.repository;

import com.erickleo.logitrack.modules.warehouse.entity.WarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WarehouseRepository extends JpaRepository<WarehouseEntity, UUID> {
}
