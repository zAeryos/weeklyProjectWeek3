package it.epicode.dao;

import it.epicode.entities.Loan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class LoanDAO {
    private EntityManagerFactory    emf;
    private EntityManager           em;

    public LoanDAO(){
        emf = Persistence.createEntityManagerFactory("catalog");
        em  = emf.createEntityManager();
    }
    public void createLoan(Loan loan) {
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(loan);
        et.commit();

    }

    public Loan getLoanById(int id) {
        return em.find(Loan.class, id);
    }

    public void deleteLoan(int id) {
        EntityTransaction   et              = em.getTransaction();
        Loan                loan  = getLoanById(id);

        et.begin();
        em.remove(loan);
        et.commit();

    }
}
