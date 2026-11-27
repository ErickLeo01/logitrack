package com.erickleo.logitrack.modules.delivery.exception;

public class DeliveryPersonExistingPhoneException extends RuntimeException {
    public DeliveryPersonExistingPhoneException() {
        super("Telefone já existe. Tente novamente.");
    }
}
