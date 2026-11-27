package com.erickleo.logitrack.modules.delivery.exception;

public class DeliveryPersonExistingEmailException extends RuntimeException {
    public DeliveryPersonExistingEmailException() {
        super("E-mail já existe. Tente novamente.");
    }
}
