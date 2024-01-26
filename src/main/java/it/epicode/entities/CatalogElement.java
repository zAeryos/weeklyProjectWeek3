package it.epicode.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "catalog_element")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "element_type", discriminatorType = DiscriminatorType.STRING)
public abstract class CatalogElement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int         isbn;
    @Column(nullable = false)
    private String      title;
    @Column(name = "publication_year", nullable = false)
    private int         publicationYear;
    @Column(name = "page_count")
    private int         pageCount;
    @OneToOne(mappedBy = "borrowedItem")
    private Loan        loan;

    public CatalogElement(String title, Integer publicationYear, int pageCount) {
        this.title              = title;
        this.publicationYear    = publicationYear;
        this.pageCount          = pageCount;
    }

    public CatalogElement() {
    }

    public Integer getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", pageCount=" + pageCount +
                '}';
    }
}
