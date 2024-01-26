package it.epicode.dao;

import it.epicode.entities.CatalogElement;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

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

    public CatalogElement getElementById(int isbn) {
        return em.find(CatalogElement.class, isbn);
    }

    public void deleteCatalogElement(int id) {
        EntityTransaction   et              = em.getTransaction();
        CatalogElement      catalogElement  = getElementById(id);

        et.begin();
        em.remove(catalogElement);
        et.commit();

    }

    public CatalogElement getElementByISBN(int isbn) {
        return em.createQuery("SELECT ce FROM CatalogElement ce WHERE ce.isbn = :isbn", CatalogElement.class)
                .setParameter("isbn", isbn)
                .getSingleResult();
    }

    public List<CatalogElement> getElementsByPublicationYear(int publicationYear) {
        return em.createQuery("SELECT ce FROM CatalogElement ce WHERE ce.publicationYear = :publicationYear", CatalogElement.class)
                .setParameter("publicationYear", publicationYear)
                .getResultList();
    }

    public List<CatalogElement> getElementsByAuthor(String author) {
        return em.createQuery("SELECT b FROM Book b WHERE b.author = :author", CatalogElement.class)
                .setParameter("author", author)
                .getResultList();
    }

    public List<CatalogElement> getElementsByTitle(String title) {
        return em.createQuery("SELECT ce FROM CatalogElement ce WHERE LOWER(ce.title) LIKE LOWER(:title)", CatalogElement.class)
                .setParameter("title", "%" + title + "%")
                .getResultList();
    }
}
