package com.erickleo.logitrack.modules.warehouse.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record WarehouseResponseDTO(UUID id, String name, String address, String country, String city, String state, Boolean status, LocalDateTime creationDate) {
}
