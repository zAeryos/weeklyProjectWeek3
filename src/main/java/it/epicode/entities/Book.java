package it.epicode.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("book")
public class Book extends CatalogElement {
    @Column(nullable = false)
    private String author;
    private String genre;

    public Book(String title, int publicationYear, int pageCount, String author, String genre) {
        super(title, publicationYear, pageCount);
        this.author = author;
        this.genre  = genre;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "  title='"             + getTitle() + '\'' +
                ", publicationYear='"   + getPublicationYear() + '\'' +
                ", pageCount='"         + getPageCount() + '\'' +
                ", author='"            + author + '\'' +
                ", genre='"             + genre + '\'' +
                ", ISBN='"              + getIsbn() + '\'' +
                '}';
    }
}
