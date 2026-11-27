package com.erickleo.logitrack.modules.product.service;

import com.erickleo.logitrack.modules.product.dto.ProductDTO;
import com.erickleo.logitrack.modules.product.dto.ProductResponseDTO;
import com.erickleo.logitrack.modules.product.entity.ProductEntity;
import com.erickleo.logitrack.modules.product.exception.ProductNotFoundException;
import com.erickleo.logitrack.modules.product.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class ProductUpdateUseCase {

    @Autowired
    private ProductRepository productRepository;

    public ProductResponseDTO updateProduct(UUID id, @Valid ProductDTO productDTO) {

        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        if(productDTO.name() != null && !productDTO.name().isBlank()) {
            productEntity.setName(productDTO.name());
        }

        if(productDTO.description() != null && !productDTO.description().isBlank()) {
            productEntity.setDescription(productDTO.description());
        }

        if(productDTO.category() != null && !productDTO.category().isBlank()) {
            productEntity.setCategory(productDTO.category());
        }

        if(productDTO.brand() != null && !productDTO.brand().isBlank()) {
            productEntity.setBrand(productDTO.brand());
        }

        if(productDTO.productCode() != null && !productDTO.brand().isBlank()) {
            productEntity.setProductCode(productDTO.productCode());
        }

        if(productDTO.price() != null) {
            productEntity.setPrice(productDTO.price());
        }

        ProductEntity updatedProduct = productRepository.save(productEntity);

        return new ProductResponseDTO(
                updatedProduct.getId(),
                updatedProduct.getName(),
                updatedProduct.getDescription(),
                updatedProduct.getCategory(),
                updatedProduct.getBrand(),
                updatedProduct.getProductCode(),
                updatedProduct.getPrice(),
                updatedProduct.getStatus()
        );
    }
}