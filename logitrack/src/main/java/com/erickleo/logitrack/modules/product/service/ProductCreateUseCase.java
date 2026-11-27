package com.erickleo.logitrack.modules.product.service;

import com.erickleo.logitrack.modules.product.dto.ProductDTO;
import com.erickleo.logitrack.modules.product.dto.ProductResponseDTO;
import com.erickleo.logitrack.modules.product.entity.ProductEntity;
import com.erickleo.logitrack.modules.product.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCreateUseCase {

    @Autowired
    private ProductRepository productRepository;

    public ProductResponseDTO createProduct(@Valid ProductDTO productDTO) {

        ProductEntity productEntity = new ProductEntity();

        productEntity.setName(productDTO.name());
        productEntity.setDescription(productDTO.description());
        productEntity.setCategory(productDTO.category());
        productEntity.setBrand(productDTO.brand());
        productEntity.setProductCode(productDTO.productCode());
        productEntity.setPrice(productDTO.price());
        productEntity.setStatus(true);

        ProductEntity savedProduct = productRepository.save(productEntity);

        return new ProductResponseDTO(
                savedProduct.getId(),
                savedProduct.getName(),
                savedProduct.getDescription(),
                savedProduct.getCategory(),
                savedProduct.getBrand(),
                savedProduct.getProductCode(),
                savedProduct.getPrice(),
                savedProduct.getStatus()
        );
    }
}