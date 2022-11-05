package com.malagueta.backend.credito.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

public class GenericJDBCRepository<T>  {
private Logger log=LoggerFactory.getLogger(GenericJDBCRepository.class);
protected Class<T> type;

@PersistenceUnit
protected EntityManagerFactory emgFactory;
    public T saveUpdate(T transactional) {
        EntityManager storage=emgFactory.createEntityManager();
        storage.getTransaction().begin();
        T t=storage.merge(transactional);
        storage.getTransaction().commit();
        storage.close();
        return t;
    }

    public List<T> getAll(Object o) {
        EntityManager storage=emgFactory.createEntityManager();
        storage.getTransaction().begin();
        List<T> list = (List<T>) storage.createQuery(" from  "+o.getClass().getName(), o.getClass()).getResultList();
        storage.close();
        return list;

    }

    public T findByID(T t){
        EntityManager storage=emgFactory.createEntityManager();
        storage.getTransaction().begin();
        T found= (T) storage.find(type.getClass(),t);
        storage.close();
        return found;
    }

}
