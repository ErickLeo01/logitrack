package com.erickleo.logitrack.modules.product.service;

import com.erickleo.logitrack.modules.product.exception.ProductNotFoundException;
import com.erickleo.logitrack.modules.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductDeleteUseCase {

    @Autowired
    private ProductRepository productRepository;

    public String deleteProduct(UUID id) {

        if(!productRepository.existsById(id)) {
            throw new ProductNotFoundException();
        }

        productRepository.deleteById(id);

        return "Produto deletado com sucesso.";
    }
}