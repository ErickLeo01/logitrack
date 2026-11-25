package com.erickleo.logitrack.modules.user.service;

import com.erickleo.logitrack.modules.user.dto.UserResponseDTO;
import com.erickleo.logitrack.modules.user.entity.UserEntity;
import com.erickleo.logitrack.modules.user.exception.UserNotFoundException;
import com.erickleo.logitrack.modules.user.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserFindByIdUseCase {

    @Autowired
    private UserRepository userRepository;

    public UserResponseDTO findUser(UUID id) {

        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);

        return new UserResponseDTO(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getUserRole()
        );
    }
}
