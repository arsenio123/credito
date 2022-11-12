package com.malagueta.backend.credito.repository.impl.search;

import com.malagueta.backend.credito.model.Cliente;
import com.malagueta.backend.credito.model.Credito;
import com.malagueta.backend.credito.model.CreditoSatus;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface SearchCredito extends JpaRepository<Credito, Long>, QueryByExampleExecutor<Credito> {
    @Query("select c from Credito c where c.cliente=?1 or c.estado=?2")
    public List<Credito> findByClienteAndEstado(Cliente cliente, CreditoSatus estado);

    @Query("select c from Credito c where c.estado=?1")
    public List<Credito> findByEstado(CreditoSatus estado);//, Date beginDateMin,Date beginDateMax);
    @Query("select c from Credito c where ?1 is null or c.estado=?1 and " +
            "?2 is null or c.beginDate>=?2 and" +
            " ?3 is null or c.beginDate<=?3 and " +
            "?4 is null or c.valor=?4")
    public List<Credito> findByEstadoAndBegindate(Optional <String> estado,
                                                        Optional <Date> beginDateMin,
                                                        Optional <Date> beginDateMax,
                                                        Optional <Double> valor);
}
