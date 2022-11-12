package com.malagueta.backend.credito.services;

import com.malagueta.backend.credito.model.Producto;
import com.malagueta.backend.credito.model.ProductoEstados;

import java.util.List;

public interface ServicoProducto {
    public Producto creat(Producto producto);

    public List<Producto> listarTodos();

    public List<Producto> listarPorEstado(ProductoEstados estado);

}
