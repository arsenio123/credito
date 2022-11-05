package com.malagueta.backend.credito.repository.impl.search;

import com.malagueta.backend.credito.model.Credito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SearchCredito extends JpaRepository<Credito, Long> {
    @Query("select c from Credito c where c.cliente=:cliente_id and c.estado=:estado")
    public List<Credito> findByClienteAndEstado(int cliente, int estado);
}
