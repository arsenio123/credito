package com.malagueta.backend.credito.repository;

import com.malagueta.backend.credito.model.Producto;
import com.malagueta.backend.credito.model.ProductoEstados;

import java.util.List;

public interface ProductRepository {

    Producto add(Producto producto);

    List<Producto> listAll();

    List<Producto> listByStatus(ProductoEstados estados);
}
