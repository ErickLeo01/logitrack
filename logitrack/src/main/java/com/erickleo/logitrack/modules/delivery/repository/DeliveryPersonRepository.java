package com.erickleo.logitrack.modules.delivery.repository;

import com.erickleo.logitrack.modules.delivery.entity.DeliveryPersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeliveryPersonRepository extends JpaRepository<DeliveryPersonEntity, UUID> {

    boolean existsByEmail(String email);
    boolean existsByDocument(String document);
}
