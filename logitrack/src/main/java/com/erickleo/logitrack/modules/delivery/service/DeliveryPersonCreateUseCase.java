package com.erickleo.logitrack.modules.delivery.service;

import com.erickleo.logitrack.modules.delivery.dto.DeliveryPersonDTO;
import com.erickleo.logitrack.modules.delivery.dto.DeliveryPersonResponseDTO;
import com.erickleo.logitrack.modules.delivery.entity.DeliveryPersonEntity;
import com.erickleo.logitrack.modules.delivery.repository.DeliveryPersonRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryPersonCreateUseCase {

    @Autowired
    private DeliveryPersonRepository deliveryPersonRepository;

    public DeliveryPersonResponseDTO createDeliveryPerson(@Valid DeliveryPersonDTO deliveryPersonDTO) {

        DeliveryPersonEntity deliveryPersonEntity = new DeliveryPersonEntity();

        deliveryPersonEntity.setName(deliveryPersonDTO.name());
        deliveryPersonEntity.setEmail(deliveryPersonDTO.email());
        deliveryPersonEntity.setPhone(deliveryPersonDTO.phone());
        deliveryPersonEntity.setDocument(deliveryPersonDTO.document());
        deliveryPersonEntity.setStatus(true);
        deliveryPersonEntity.setCreationDate(deliveryPersonDTO.creationDate());

        DeliveryPersonEntity savedDeliveryPerson = deliveryPersonRepository.save(deliveryPersonEntity);

        return new DeliveryPersonResponseDTO(
                savedDeliveryPerson.getId(),
                savedDeliveryPerson.getName(),
                savedDeliveryPerson.getEmail(),
                savedDeliveryPerson.getPhone(),
                savedDeliveryPerson.getDocument(),
                savedDeliveryPerson.getStatus(),
                savedDeliveryPerson.getCreationDate()
        );
    }
}