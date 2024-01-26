package it.epicode.dao;

import it.epicode.entities.CatalogElement;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CatalogDAO {
    private EntityManagerFactory    emf;
    private EntityManager           em;

    public CatalogDAO(){
        emf = Persistence.createEntityManagerFactory("catalog");
        em  = emf.createEntityManager();
    }
    public void createCatalogElement(CatalogElement catalogElement) {
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(catalogElement);
        et.commit();

    }

    public CatalogElement getElementById(int id) {
        return em.find(CatalogElement.class, id);
    }

    public void deleteCatalogElement(int id) {
        EntityTransaction   et              = em.getTransaction();
        CatalogElement      catalogElement  = getElementById(id);

        et.begin();
        em.remove(catalogElement);
        et.commit();

    }
}
