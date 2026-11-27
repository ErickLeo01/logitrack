package com.erickleo.logitrack.modules.product.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductResponseDTO(UUID id,String name, String description, String category, String brand, String productCode, BigDecimal price, Boolean status) {
}
