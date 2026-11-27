package com.erickleo.logitrack.modules.product.service;

import com.erickleo.logitrack.modules.product.dto.ProductResponseDTO;
import com.erickleo.logitrack.modules.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class ProductListUseCase {

    @Autowired
    private ProductRepository productRepository;

    public Page<ProductResponseDTO> listProducts(Pageable pageable) {

        return productRepository.findAll(pageable)

        .map(product -> new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getCategory(),
                product.getBrand(),
                product.getProductCode(),
                product.getPrice(),
                product.getStatus()
        ));
    }
}