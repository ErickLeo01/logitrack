package com.erickleo.logitrack.modules.product.service;

import com.erickleo.logitrack.modules.product.dto.ProductResponseDTO;
import com.erickleo.logitrack.modules.product.entity.ProductEntity;
import com.erickleo.logitrack.modules.product.exception.ProductNotFoundException;
import com.erickleo.logitrack.modules.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductFindByIdUseCase {

    @Autowired
    private ProductRepository productRepository;

    public ProductResponseDTO findProduct(UUID id) {

        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        return new ProductResponseDTO(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getCategory(),
                productEntity.getBrand(),
                productEntity.getProductCode(),
                productEntity.getPrice(),
                productEntity.getStatus()
        );
    }
}
