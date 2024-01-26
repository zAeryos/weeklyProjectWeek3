package it.epicode.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int             id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_fk")
    private User            user;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "catalog_element_fk")
    private CatalogElement  borrowedItem;
    @Column(name = "start_date")
    private LocalDate       startDate;
    @Column(name = "due_date")
    private LocalDate       dueDate;
    @Column(name = "return_date")
    private LocalDate       returnDate;

    public Loan(User user, CatalogElement borrowedItem) {
        this.user           = user;
        this.borrowedItem   = borrowedItem;
        this.startDate      = LocalDate.now();
        this.dueDate        = startDate.plusDays(30);
    }

    public User getUser() {
        return user;
    }

    public CatalogElement getBorrowedItem() {
        return borrowedItem;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
    @Override
    public String toString() {
        return "Loan{" +
                "user=" + user +
                ", borrowedItem=" + borrowedItem +
                ", startDate=" + startDate +
                ", dueDate=" + dueDate +
                ", returnDate=" + returnDate +
                '}';
    }
}