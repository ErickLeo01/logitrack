package com.erickleo.logitrack.modules.product.repository;

import com.erickleo.logitrack.modules.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {

    Optional<ProductEntity> findByProductCode(String productCode);

    boolean existsByProductCode(String productCode);
}
