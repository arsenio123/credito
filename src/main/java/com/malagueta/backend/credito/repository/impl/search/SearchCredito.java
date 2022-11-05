package com.malagueta.backend.credito.repository.impl.search;

import com.malagueta.backend.credito.model.Cliente;
import com.malagueta.backend.credito.model.Credito;
import com.malagueta.backend.credito.model.CreditoSatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SearchCredito extends JpaRepository<Credito, Long> {
    @Query("select c from Credito c where c.cliente=?1 or c.estado=?2")
    public List<Credito> findByClienteAndEstado(Cliente cliente, CreditoSatus estado);

}
