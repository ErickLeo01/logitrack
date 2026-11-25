package com.erickleo.logitrack.modules.user.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("Usuário não encontrado. Tente novamente.");
    }
}
