package com.erickleo.logitrack.modules.user.service;

import com.erickleo.logitrack.modules.user.exception.UserNotFoundException;
import com.erickleo.logitrack.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserDeleteUseCase {

    @Autowired
    private UserRepository userRepository;

    public String deleteUser(UUID id) {

        if(!userRepository.existsById(id)) {
            throw new UserNotFoundException();
        }

        userRepository.deleteById(id);

        return "Usuário deletado com sucesso!";
    }
}
