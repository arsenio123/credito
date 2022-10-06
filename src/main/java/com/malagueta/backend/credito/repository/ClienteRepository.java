package com.malagueta.backend.credito.repository;


import com.malagueta.backend.credito.model.Cliente;

public interface ClienteRepository {
    public Cliente regista(Cliente cliente);
    public Cliente findCleinte(Cliente cliente);

}
