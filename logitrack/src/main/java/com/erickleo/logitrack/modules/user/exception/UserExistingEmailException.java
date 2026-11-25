package com.erickleo.logitrack.modules.user.exception;

public class UserExistingEmailException extends RuntimeException {
    public UserExistingEmailException() {
        super("E-mail já existe. Tente novamente.");
    }
}
