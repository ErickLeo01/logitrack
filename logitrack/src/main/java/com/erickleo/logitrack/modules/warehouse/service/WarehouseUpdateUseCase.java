package com.erickleo.logitrack.modules.warehouse.service;

import com.erickleo.logitrack.modules.warehouse.dto.WarehouseDTO;
import com.erickleo.logitrack.modules.warehouse.dto.WarehouseResponseDTO;
import com.erickleo.logitrack.modules.warehouse.entity.WarehouseEntity;
import com.erickleo.logitrack.modules.warehouse.exception.WarehouseNotFoundException;
import com.erickleo.logitrack.modules.warehouse.repository.WarehouseRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WarehouseUpdateUseCase {

    @Autowired
    private WarehouseRepository warehouseRepository;

    public WarehouseResponseDTO updateWarehouse(UUID id, @Valid WarehouseDTO warehouseDTO) {

        WarehouseEntity warehouseEntity = warehouseRepository.findById(id)
                .orElseThrow(WarehouseNotFoundException::new);

        if(warehouseDTO.name() != null && !warehouseDTO.name().isBlank()) {
            warehouseEntity.setName(warehouseDTO.name());
        }

        if(warehouseDTO.address() != null && !warehouseDTO.address().isBlank()) {
            warehouseEntity.setAddress(warehouseDTO.address());
        }

        if(warehouseDTO.country() != null && !warehouseDTO.country().isBlank()) {
            warehouseEntity.setCountry(warehouseDTO.country());
        }

        if(warehouseDTO.city() != null && !warehouseDTO.city().isBlank()) {
            warehouseEntity.setCity(warehouseDTO.city());
        }

        if(warehouseDTO.state() != null && !warehouseDTO.state().isBlank()) {
            warehouseEntity.setState(warehouseDTO.state());
        }

        WarehouseEntity updatedWarehouse = warehouseRepository.save(warehouseEntity);

        return new WarehouseResponseDTO(
                updatedWarehouse.getId(),
                updatedWarehouse.getName(),
                updatedWarehouse.getAddress(),
                updatedWarehouse.getCountry(),
                updatedWarehouse.getCity(),
                updatedWarehouse.getState(),
                updatedWarehouse.getStatus(),
                updatedWarehouse.getCreationDate()
        );
    }
}