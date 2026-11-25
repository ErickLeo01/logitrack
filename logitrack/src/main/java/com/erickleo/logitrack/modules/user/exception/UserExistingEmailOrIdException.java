package com.erickleo.logitrack.modules.user.exception;

public class UserExistingEmailOrIdException extends RuntimeException {
    public UserExistingEmailOrIdException() {
        super("Usuário j´s existente. E-mail ou ID já existem. Tente novamente.");
    }
}
