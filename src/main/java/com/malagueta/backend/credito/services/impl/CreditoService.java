package com.malagueta.backend.credito.services.impl;


import com.malagueta.backend.credito.model.Credito;
import com.malagueta.backend.credito.repository.CreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditoService {
    private CreditoRepository creditoRepository;


    @Autowired
    public CreditoService(CreditoRepository creditoRepository){this.creditoRepository = creditoRepository;
    }
    public List<Credito> getCreditoRepository() {
        return creditoRepository.getAllCredit();
    }

    public Credito creatCredito(Credito credito) {
        return creditoRepository.createCredito(credito);
    }
}
