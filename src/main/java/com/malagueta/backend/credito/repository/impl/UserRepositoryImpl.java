package com.malagueta.backend.credito.repository.impl;

import com.malagueta.backend.credito.model.User;
import com.malagueta.backend.credito.repository.UserRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Component
public class UserRepositoryImpl implements UserRepository {

    @PersistenceUnit
    EntityManagerFactory emf;


    @Override
    public List<User> getUsers() {
        EntityManager entityManager=emf.createEntityManager();
        entityManager.getTransaction().begin();
        List<User> users=entityManager.createQuery("select u from User u", User.class).getResultList();
        entityManager.close();
        return users;
    }

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public User findByName(String usrName) {
        EntityManager entityManager=emf.createEntityManager();
        entityManager.getTransaction().begin();
        System.out.println("looking for user "+usrName);
        User user=entityManager.createQuery("select  u from User u where u.name = :n ", User.class).setParameter("n", usrName).getSingleResult();
        entityManager.close();

/*
        TypedQuery<Employee> query = em.createQuery(
                "SELECT e FROM Employee e WHERE e.empNumber = :number" , Employee.class);
        String empNumber = "A123";
        Employee employee = query.setParameter("number", empNumber).getSingleResult();
*/

        return user;
    }
}
