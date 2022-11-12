package com.malagueta.backend.credito.services.impl;

import com.malagueta.backend.credito.model.Producto;
import com.malagueta.backend.credito.model.ProductoEstados;
import com.malagueta.backend.credito.repository.ProductRepository;
import com.malagueta.backend.credito.services.ServicoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoProductoImpl implements ServicoProducto {

    @Autowired
    private ProductRepository producyRepository;

    @Override
    public Producto creat(Producto producto) {
        return producyRepository.add(producto);
    }

    @Override
    public List<Producto> listarTodos() {
        return producyRepository.listAll();
    }

    @Override
    public List<Producto> listarPorEstado(ProductoEstados estados) {
        return producyRepository.listByStatus(estados);
    }
}
