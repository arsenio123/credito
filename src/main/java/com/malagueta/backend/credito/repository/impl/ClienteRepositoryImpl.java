package com.malagueta.backend.credito.repository.impl;

import com.malagueta.backend.credito.model.Cliente;
import com.malagueta.backend.credito.repository.ClienteRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Component
public class ClienteRepositoryImpl implements ClienteRepository {
    @PersistenceUnit
    EntityManagerFactory factory;

    @Override
    public Cliente findCleinte(Cliente cliente) {
        EntityManager manager=factory.createEntityManager();
        Cliente clienteEncontrado = (Cliente) manager.createQuery("select c from Cliente c where c.nome=:name")
                .setParameter("name",cliente.getNome())
                .getSingleResult();
        manager.close();
        return clienteEncontrado;
    }

    @Override
    public Cliente regista(Cliente cliente) {
        EntityManager manager=factory.createEntityManager();
        manager.getTransaction().begin();
        Cliente clienteINtroduzido=manager.merge(cliente);
        manager.getTransaction().commit();
        manager.close();
        return clienteINtroduzido;
    }
}
