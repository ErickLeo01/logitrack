package com.erickleo.logitrack.modules.warehouse.service;

import com.erickleo.logitrack.modules.warehouse.exception.WarehouseNotFoundException;
import com.erickleo.logitrack.modules.warehouse.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WarehouseDeleteUseCase {

    @Autowired
    private WarehouseRepository warehouseRepository;

    public String deleteWarehouse(UUID id) {

        if(!warehouseRepository.existsById(id)) {
            throw new WarehouseNotFoundException();
        }

        warehouseRepository.deleteById(id);

        return "Armazém deletado com sucesso.";
    }

}