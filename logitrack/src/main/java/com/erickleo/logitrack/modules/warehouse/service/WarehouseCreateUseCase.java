package com.erickleo.logitrack.modules.warehouse.service;

import com.erickleo.logitrack.modules.warehouse.dto.WarehouseDTO;
import com.erickleo.logitrack.modules.warehouse.dto.WarehouseResponseDTO;
import com.erickleo.logitrack.modules.warehouse.entity.WarehouseEntity;
import com.erickleo.logitrack.modules.warehouse.repository.WarehouseRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class WarehouseCreateUseCase {

    @Autowired
    private WarehouseRepository warehouseRepository;

    public WarehouseResponseDTO createWarehouse(@Valid WarehouseDTO warehouseDTO) {

        WarehouseEntity warehouseEntity = new WarehouseEntity();

        warehouseEntity.setName(warehouseDTO.name());
        warehouseEntity.setAddress(warehouseDTO.address());
        warehouseEntity.setCountry(warehouseDTO.country());
        warehouseEntity.setCity(warehouseDTO.city());
        warehouseEntity.setState(warehouseDTO.state());
        warehouseEntity.setStatus(true);
        warehouseEntity.setCreationDate(LocalDateTime.now());

        WarehouseEntity savedWarehouse = warehouseRepository.save(warehouseEntity);

        return new WarehouseResponseDTO(
                savedWarehouse.getId(),
                savedWarehouse.getName(),
                savedWarehouse.getAddress(),
                savedWarehouse.getCountry(),
                savedWarehouse.getCity(),
                savedWarehouse.getState(),
                savedWarehouse.getStatus(),
                savedWarehouse.getCreationDate()
        );
    }
}