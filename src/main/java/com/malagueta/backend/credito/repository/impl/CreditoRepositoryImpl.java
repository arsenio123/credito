package com.malagueta.backend.credito.repository.impl;


import com.malagueta.backend.credito.model.Credito;
import com.malagueta.backend.credito.repository.CreditoRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.Calendar;
import java.util.List;


@Profile("JPA")
@Component
public class CreditoRepositoryImpl implements CreditoRepository {

    @PersistenceUnit
    private EntityManagerFactory emgFactory;

    public CreditoRepositoryImpl(){
    }
    @Override
    public List<Credito> getAllCredit() {
        EntityManager manager=emgFactory.createEntityManager();
        System.out.println("numero de entraas "+manager.createQuery("select c from Credito c").getResultList().size());
        List<Credito> creditos= manager.createQuery("select c from Credito c").getResultList();
        manager.close();
        return  creditos;
    }

    @Override
    public Credito createCredito(Credito credito) {
        EntityManager maneger=emgFactory.createEntityManager();
        maneger.getTransaction().begin();

        credito.setUpdateDate(Calendar.getInstance().getTime());
        credito.setCreatedDate(Calendar.getInstance().getTime());

        Credito c1=maneger.merge(credito);
        maneger.getTransaction().commit();
        maneger.close();
        return c1;
    }
}
