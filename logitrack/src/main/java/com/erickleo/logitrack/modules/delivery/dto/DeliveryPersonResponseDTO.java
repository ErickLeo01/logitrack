package com.erickleo.logitrack.modules.delivery.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record DeliveryPersonResponseDTO(UUID id, String name, String email, String phone, String document, Boolean status, LocalDateTime creationDate) {
}
