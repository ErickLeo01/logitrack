package com.erickleo.logitrack.modules.delivery.service;

import com.erickleo.logitrack.modules.delivery.dto.DeliveryPersonDTO;
import com.erickleo.logitrack.modules.delivery.dto.DeliveryPersonResponseDTO;
import com.erickleo.logitrack.modules.delivery.entity.DeliveryPersonEntity;
import com.erickleo.logitrack.modules.delivery.exception.DeliveryPersonExistingDocumentException;
import com.erickleo.logitrack.modules.delivery.exception.DeliveryPersonExistingEmailException;
import com.erickleo.logitrack.modules.delivery.exception.DeliveryPersonExistingPhoneException;
import com.erickleo.logitrack.modules.delivery.exception.DeliveryPersonNotFoundException;
import com.erickleo.logitrack.modules.delivery.repository.DeliveryPersonRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeliveryPersonUpdateUseCase {

    @Autowired
    private DeliveryPersonRepository deliveryPersonRepository;

    public DeliveryPersonResponseDTO updateDeliveryPerson(UUID id, @Valid DeliveryPersonDTO deliveryPersonDTO) {

        DeliveryPersonEntity deliveryPersonEntity = deliveryPersonRepository.findById(id)
                .orElseThrow(DeliveryPersonNotFoundException::new);

        if (deliveryPersonDTO.name() != null && !deliveryPersonDTO.name().isBlank()) {
            deliveryPersonEntity.setName(deliveryPersonDTO.name());
        }

        if (deliveryPersonDTO.email() != null && !deliveryPersonDTO.email().isBlank() && deliveryPersonDTO.email().equals(deliveryPersonEntity.getEmail())) {

            if (deliveryPersonRepository.existsByEmail(deliveryPersonDTO.email())) {
                throw new DeliveryPersonExistingEmailException();
            }
        }

        if (deliveryPersonDTO.phone() != null && !deliveryPersonDTO.phone().isBlank() && deliveryPersonDTO.phone().equals(deliveryPersonEntity.getPhone())) {

            if (deliveryPersonRepository.existsByPhone(deliveryPersonDTO.phone())) {
                throw new DeliveryPersonExistingPhoneException();
            }
        }

        if (deliveryPersonDTO.document() != null && !deliveryPersonDTO.document().isBlank() && deliveryPersonDTO.document().equals(deliveryPersonEntity.getDocument())) {

            if (deliveryPersonRepository.existsByDocument(deliveryPersonDTO.document())) {
                throw new DeliveryPersonExistingDocumentException();
            }
        }

        if(deliveryPersonDTO.creationDate() != null) {
            deliveryPersonEntity.setCreationDate(deliveryPersonDTO.creationDate());
        }

        DeliveryPersonEntity updatedDeliveryPerson = deliveryPersonRepository.save(deliveryPersonEntity);

        return new DeliveryPersonResponseDTO(
                updatedDeliveryPerson.getId(),
                updatedDeliveryPerson.getName(),
                updatedDeliveryPerson.getEmail(),
                updatedDeliveryPerson.getPhone(),
                updatedDeliveryPerson.getDocument(),
                updatedDeliveryPerson.getStatus(),
                updatedDeliveryPerson.getCreationDate()
        );
    }
}