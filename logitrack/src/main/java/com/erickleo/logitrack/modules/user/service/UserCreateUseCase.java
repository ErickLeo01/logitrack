package com.erickleo.logitrack.modules.user.service;

import com.erickleo.logitrack.modules.user.dto.UserDTO;
import com.erickleo.logitrack.modules.user.dto.UserResponseDTO;
import com.erickleo.logitrack.modules.user.entity.UserEntity;
import com.erickleo.logitrack.modules.user.exception.UserExistingEmailException;
import com.erickleo.logitrack.modules.user.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCreateUseCase {

    @Autowired
    private UserRepository userRepository;

    public UserResponseDTO createUser(@Valid UserDTO userDTO) {

        UserEntity userEntity = new UserEntity();

        userEntity.setName(userDTO.name());
        userEntity.setEmail(userDTO.email());
        userEntity.setPassword(userDTO.password());
        userEntity.setUserRole(userDTO.userRole());

        if (userRepository.existsByEmail(userEntity.getEmail())) {
            throw new UserExistingEmailException();
        }

        UserEntity savedUser = userRepository.save(userEntity);

        return new UserResponseDTO(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getUserRole()
        );
    }
}