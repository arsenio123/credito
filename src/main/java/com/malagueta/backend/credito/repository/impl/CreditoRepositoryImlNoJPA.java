package com.malagueta.backend.credito.repository.impl;

import com.malagueta.backend.credito.model.Credito;
import com.malagueta.backend.credito.model.User;
import com.malagueta.backend.credito.repository.CreditoRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;

@Profile("noJPA")
@Component
public class CreditoRepositoryImlNoJPA implements CreditoRepository {

    @Override
    public List<Credito> getAllCredit() {
        return null;
    }

    @Override
    public Credito createCredito(Credito credito) {
        credito=new Credito();
        credito.setAprovadoPOr(new User());
        credito.setCreatedBy(new User());
        credito.setJurus(30);
        credito.setDoDate(Calendar.getInstance().getTime());
        credito.setValor(500);
        credito.setUpdateDate(Calendar.getInstance().getTime());
        credito.setCreatedDate(Calendar.getInstance().getTime());
        return credito;
    }
}
