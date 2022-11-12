package com.malagueta.backend.credito.repository.impl;

import com.malagueta.backend.credito.model.Producto;
import com.malagueta.backend.credito.model.ProductoEstados;
import com.malagueta.backend.credito.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Component
public class ProductRepositoryImpl extends GenericJDBCRepository<Producto> implements ProductRepository {

   // private EntityManagerFactory managerFactory;

    @Override
    public Producto add(Producto producto) {
      /*  EntityManager em=managerFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(producto);
        em.close();*/
        return saveUpdate(producto);
    }

    @Override
    public List<Producto> listAll() {
        return null;
    }

    @Override
    public List<Producto> listByStatus(ProductoEstados estados) {
        return null;
    }
}
