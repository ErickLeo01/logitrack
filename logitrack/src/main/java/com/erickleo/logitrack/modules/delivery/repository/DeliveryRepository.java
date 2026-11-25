package com.erickleo.logitrack.modules.delivery.repository;

import com.erickleo.logitrack.modules.delivery.entity.DeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DeliveryRepository extends JpaRepository<DeliveryEntity, UUID> {

    Optional<DeliveryEntity> findByTrackingCode(String trackingCode);

    Optional<DeliveryEntity> findByOrderId(UUID orderId);
}
