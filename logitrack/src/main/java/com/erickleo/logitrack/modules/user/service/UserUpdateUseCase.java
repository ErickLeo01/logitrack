package com.erickleo.logitrack.modules.user.service;

import com.erickleo.logitrack.modules.user.dto.UserDTO;
import com.erickleo.logitrack.modules.user.dto.UserResponseDTO;
import com.erickleo.logitrack.modules.user.entity.UserEntity;
import com.erickleo.logitrack.modules.user.exception.UserExistingEmailException;
import com.erickleo.logitrack.modules.user.exception.UserNotFoundException;
import com.erickleo.logitrack.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserUpdateUseCase {

    @Autowired
    private UserRepository userRepository;

    public UserResponseDTO updateUser(UUID id, UserDTO userDTO) {

        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);

        if(userDTO.name() != null && !userDTO.name().isBlank()) {
            userEntity.setName(userDTO.name());
        }

        if(userDTO.email() != null && !userDTO.email().isBlank() && !userDTO.email().equals(userEntity.getEmail())) {

            if(userRepository.existsByEmail(userDTO.email())) {
                throw new UserExistingEmailException();
            }

            userEntity.setEmail(userDTO.email());
        }

        if(userDTO.password() != null && !userDTO.password().isBlank()) {
            userEntity.setPassword(userDTO.password());
        }

        UserEntity updatedUser = userRepository.save(userEntity);

        return new UserResponseDTO(
                updatedUser.getId(),
                updatedUser.getName(),
                updatedUser.getEmail(),
                updatedUser.getUserRole()
        );
    }
}