package com.erickleo.logitrack.modules.warehouse.exception;

public class WarehouseNotFoundException extends RuntimeException {
    public WarehouseNotFoundException() {
        super("Armazem não encontrado. Tente novamente.");
    }
}
