package com.erickleo.logitrack.modules.warehouse.service;

import com.erickleo.logitrack.modules.warehouse.dto.WarenhouseDTO;
import com.erickleo.logitrack.modules.warehouse.dto.WarenhouseResponseDTO;
import com.erickleo.logitrack.modules.warehouse.entity.WarehouseEntity;
import com.erickleo.logitrack.modules.warehouse.repository.WarehouseRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarenhouseCreateUseCase {

    @Autowired
    private WarehouseRepository warehouseRepository;

    public WarenhouseResponseDTO createWarenhouse(@Valid WarenhouseDTO warenhouseDTO) {

        WarehouseEntity warehouseEntity = new WarehouseEntity();

        warehouseEntity.setName(warenhouseDTO.name());
        warehouseEntity.setAddress(warenhouseDTO.address());
        warehouseEntity.
    }
}
