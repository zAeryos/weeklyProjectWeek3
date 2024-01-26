package it.epicode.dao;

import it.epicode.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UserDAO {
    private EntityManagerFactory    emf;
    private EntityManager           em;

    public UserDAO(){
        emf = Persistence.createEntityManagerFactory("catalog");
        em  = emf.createEntityManager();
    }
    public void createUser(User user) {
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(user);
        et.commit();

    }

    public User getUserById(int id) {
        return em.find(User.class, id);
    }

    public void deleteUser(int id) {
        EntityTransaction   et    = em.getTransaction();
        User                user  = getUserById(id);

        et.begin();
        em.remove(user);
        et.commit();

    }
}
