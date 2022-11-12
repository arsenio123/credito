package com.malagueta.backend.credito.repository.impl;


import com.malagueta.backend.credito.model.Cliente;
import com.malagueta.backend.credito.model.Credito;
import com.malagueta.backend.credito.model.CreditoSatus;
import com.malagueta.backend.credito.repository.CreditoRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


@Profile("JPA")
@Component
public class CreditoRepositoryImpl
        extends GenericJDBCRepository<Credito>
        implements CreditoRepository {

    @PersistenceUnit
    private EntityManagerFactory emgFactory;

    public Credito getAllCredit(Credito credito) {
        return findByID(credito);
    }
    @Override
    public List<Credito> getAllCredit() {
        return getAll(new Credito());
    }

    @Override
    public Credito createCredito(Credito credito) {
        return  saveUpdate(credito);
    }

    @Override
    public List<Credito> findOpenCredit(Cliente cliente) {
        EntityManager storage=emgFactory.createEntityManager();
        storage.getTransaction().begin();

        List<Credito> credits= storage.createQuery("select c from Credito c where c.cliente=:client_id and c.estado= :vigor", Credito.class)
                .setParameter("client_id",cliente)
                .setParameter("vigor", CreditoSatus.VIGOR)
                .getResultList();
        storage.close();
        return credits;
    }

    @Override
    public List<Credito> getCreditBy(Credito credito) {

        EntityManager em=emgFactory.createEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder builder=em.
                getCriteriaBuilder();
        CriteriaQuery<Credito> criteriaCredito=builder.createQuery(Credito.class);

        Root<Credito> creditQuery=criteriaCredito.from(Credito.class);
        List<Predicate> predicates=new ArrayList<>();

        if(credito.getCliente()!=null)
            predicates.add(builder.equal(creditQuery .get("cliente_id"),credito.getCliente().getId()));
        /*if(credito.getCreatedDate()!=null)
            predicates.add(builder.equal(creditTable.get("cliente_id"),credito.getCliente().getId()));
        if(credito.getCliente()!=null)
            predicates.add(builder.equal(creditTable.get("cliente_id"),credito.getCliente().getId()));
        if(credito.getCliente()!=null)
            predicates.add(builder.equal(creditTable.get("cliente_id"),credito.getCliente().getId()));
        if(credito.getCliente()!=null)
            predicates.add(builder.equal(creditTable.get("cliente_id"),credito.getCliente().getId()));
*/
        criteriaCredito.where(predicates.toArray(new Predicate[0]));

        return em.createQuery(criteriaCredito).getResultList();
    }


    /**
     *  EntityManager manager=emgFactory.createEntityManager();
     *         System.out.println("numero de entraas "+manager.createQuery("select c from Credito c").getResultList().size());
     *         List<Credito> creditos= manager.createQuery("select c from Credito c").getResultList();
     *         manager.close();
     */
}
