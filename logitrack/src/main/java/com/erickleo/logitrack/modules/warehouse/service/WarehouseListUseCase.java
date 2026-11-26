package com.erickleo.logitrack.modules.warehouse.service;

import com.erickleo.logitrack.modules.warehouse.dto.WarehouseResponseDTO;
import com.erickleo.logitrack.modules.warehouse.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
@Service
public class WarehouseListUseCase {

    @Autowired
    private WarehouseRepository warehouseRepository;

    public Page<WarehouseResponseDTO> listWarehouses(Pageable pageable) {

        return warehouseRepository.findAll(pageable)

                // Converte cada WarehouseEntity em um WarehouseResponseDTO, retornando apenas os dados
                // necessários para a resposta da API.
                // .map() é um método que permite transformar cada elemento de uma coleção em outro elemento.
                //  WarehouseEntity - WarehouseResponseDTO.
                .map(warehouse -> new WarehouseResponseDTO(
                        warehouse.getId(),
                        warehouse.getName(),
                        warehouse.getAddress(),
                        warehouse.getCountry(),
                        warehouse.getCity(),
                        warehouse.getState(),
                        warehouse.getStatus(),
                        warehouse.getCreationDate()
                ));

    }
}