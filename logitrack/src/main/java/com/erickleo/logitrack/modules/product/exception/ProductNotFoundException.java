package com.erickleo.logitrack.modules.product.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException() {
        super("Produto não encontrado. Tente novamente.");
    }
}
