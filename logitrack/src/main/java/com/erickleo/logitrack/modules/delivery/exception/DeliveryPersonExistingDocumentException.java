package com.erickleo.logitrack.modules.delivery.exception;

public class DeliveryPersonExistingDocumentException extends RuntimeException {
    public DeliveryPersonExistingDocumentException() {
        super("Documento inserido já existe. Tente novamente.");
    }
}
