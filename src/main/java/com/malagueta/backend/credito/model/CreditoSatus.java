package com.malagueta.backend.credito.model;

public enum CreditoSatus {
    VIGOR("VIGOR"),CANCELADO("CANCELADO"),VENCIDO("VENCIDO");
    private final String status;


    CreditoSatus(final String status) {
        this.status=status;
    }
}
