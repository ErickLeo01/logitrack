package com.erickleo.logitrack.modules.user.dto;

import com.erickleo.logitrack.modules.user.enumm.UserRoleEnum;

import java.util.UUID;

public record UserResponseDTO(UUID id, String name, String email, UserRoleEnum userRole
) {
}
