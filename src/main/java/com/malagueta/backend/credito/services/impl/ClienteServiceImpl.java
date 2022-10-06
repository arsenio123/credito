package com.malagueta.backend.credito.services.impl;


import com.malagueta.backend.credito.model.Cliente;
import com.malagueta.backend.credito.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente createCliente(Cliente cliente){
        return clienteRepository.regista(cliente);
    }
}
