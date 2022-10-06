package com.malagueta.backend.credito.repository;


import com.malagueta.backend.credito.model.Credito;

import java.util.List;

public interface CreditoRepository {

    public List<Credito> getAllCredit();
    public Credito createCredito(Credito credito);
}
