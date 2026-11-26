package com.erickleo.logitrack.modules.warehouse.service;

import com.erickleo.logitrack.modules.warehouse.dto.WarehouseResponseDTO;
import com.erickleo.logitrack.modules.warehouse.entity.WarehouseEntity;
import com.erickleo.logitrack.modules.warehouse.exception.WarehouseNotFoundException;
import com.erickleo.logitrack.modules.warehouse.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WarehouseFindByIdUseCase {

    @Autowired
    private WarehouseRepository warehouseRepository;

    public WarehouseResponseDTO findWarehouse(UUID id) {

        WarehouseEntity warehouseEntity = warehouseRepository.findById(id)
                .orElseThrow(WarehouseNotFoundException::new);

        return new WarehouseResponseDTO(
                warehouseEntity.getId(),
                warehouseEntity.getName(),
                warehouseEntity.getAddress(),
                warehouseEntity.getCountry(),
                warehouseEntity.getCity(),
                warehouseEntity.getState(),
                warehouseEntity.getStatus(),
                warehouseEntity.getCreationDate()
        );
    }
}