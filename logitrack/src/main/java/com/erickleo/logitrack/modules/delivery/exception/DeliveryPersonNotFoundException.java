package com.erickleo.logitrack.modules.delivery.exception;

public class DeliveryPersonNotFoundException extends RuntimeException {
    public DeliveryPersonNotFoundException() {
        super("Entregador não encontrado. Tente novamente.");
    }
}
