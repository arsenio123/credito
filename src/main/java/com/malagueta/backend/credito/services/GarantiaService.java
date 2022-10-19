package com.malagueta.backend.credito.services;

import com.malagueta.backend.credito.model.Garantia;

import java.util.List;

public interface GarantiaService {
    public List<Garantia> getGarantiafromCredito(int credito_Id);
}
