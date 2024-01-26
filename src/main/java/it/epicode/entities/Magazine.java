package it.epicode.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@DiscriminatorValue("magazine")
public class Magazine extends CatalogElement {
    @Enumerated(EnumType.STRING)
    private Periodicity periodicity;

    public Magazine(String title, int publicationYear, int pageCount, Periodicity periodicity) {
        super(title, publicationYear, pageCount);
        this.periodicity = periodicity;
    }

    public Magazine() {
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "title='" + getTitle() + " " +'\'' +
                "publicationYear='" + getPublicationYear() + " " +'\'' +
                "pageCount='" + getPageCount() + " " +'\'' +
                "periodicity=" + periodicity + " " +
                "ISBN='" + getIsbn() + " " + '\'' +
                "}\n";
    }
}
