package it.epicode;

import it.epicode.dao.CatalogDAO;
import it.epicode.entities.Book;
import it.epicode.entities.CatalogElement;
import it.epicode.entities.Magazine;
import it.epicode.entities.Periodicity;

public class UseCatalog {
    public static void main(String[] args) {
        CatalogDAO catalogDAO = new CatalogDAO();

            Book        book1       = new Book("Fantasy book", 2022, 207, "J.K.Rowling", "Fantasy");
            Book        book2       = new Book("Horror", 2017, 250, "J.S.Lolling", "Horror");
            Book        book3       = new Book("Horror", 2022, 621, "Mark Shalberg", "Horror");

            Magazine    magazine1   = new Magazine("Test Magazine1", 2019, 27, Periodicity.WEEKLY);
            Magazine    magazine2   = new Magazine("Test Magazine2", 2014, 71, Periodicity.MONTHLY);
            Magazine    magazine3   = new Magazine("Test Magazine3", 2022, 34, Periodicity.SEMI_ANNUAL);

            catalogDAO.createCatalogElement(book1);
            catalogDAO.createCatalogElement(book2);
            catalogDAO.createCatalogElement(book3);

            catalogDAO.createCatalogElement(magazine1);
            catalogDAO.createCatalogElement(magazine2);
            catalogDAO.createCatalogElement(magazine3);

//            catalogDAO.deleteCatalogElement(1);
//            catalogDAO.deleteCatalogElement(3);


        CatalogElement retrievedElement = catalogDAO.getElementByISBN(book1.getIsbn());
            System.out.println("Retrieved Element by ISBN: " + retrievedElement);

            System.out.println("Books by J.K.Rowling: ");
            System.out.println(catalogDAO.getElementsByAuthor("J.K.Rowling"));;

            System.out.println("Elements published in the year 2022: ");
            System.out.println(catalogDAO.getElementsByPublicationYear(2022));

            System.out.println("Elements with the title Horror :");
            System.out.println(catalogDAO.getElementsByTitle("Horror"));



    }
}
