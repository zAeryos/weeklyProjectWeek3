package it.epicode.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LibraryCatalog {
    private List<CatalogElement>    catalogElements;
    private List<Loan>              loans;

    public LibraryCatalog() {
        this.catalogElements = new ArrayList<>();
        this.loans = new ArrayList<>();
    }

    public List<CatalogElement> getCatalogElements() {
        return catalogElements;
    }

    public void setCatalogElements(List<CatalogElement> catalogElement) {
        this.catalogElements = catalogElement;
    }
    public List<Loan> getLoans() {
        return loans;
    }
    public void addItem(CatalogElement catalogElementItem) {
        catalogElements.add(catalogElementItem);
    }

    public void removeItem(CatalogElement catalogElementItem) {
        catalogElements.remove(catalogElementItem);
    }

    public void removeItemByIsnb(int isbn) {
        catalogElements.removeIf(item -> item.getIsbn().equals(isbn));
    }

    public Optional<CatalogElement> searchByIsbn(Integer isbn) {
        return catalogElements.stream()
                .filter(item -> item.getIsbn().equals(isbn))
                .findFirst();
    }

    public List<CatalogElement> searchByPublicationYear(int year) {
        return catalogElements.stream()
                .filter(item -> item.getPublicationYear() == year)
                .toList();
    }

    public List<CatalogElement> searchByAuthor(String author) {
        return catalogElements.stream()
                .filter(item -> ((Book) item).getAuthor().equals(author))
                .toList();
    }

    public List<Loan> getLoansByUserCardNumber(int cardNumber) {
        return loans.stream()
                .filter(loan -> loan.getUser().getCardNumber() == cardNumber)
                .collect(Collectors.toList());
    }

}
