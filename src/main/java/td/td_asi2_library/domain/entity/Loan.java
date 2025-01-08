package td.td_asi2_library.domain.entity;

import java.time.LocalDate;

public class Loan {

    // Attributs
    private Long id;
    private String isbn;
    private Long userId;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    // Constructeurs
    public Loan(Long id, String isbn, Long userId, LocalDate borrowDate) {
        this.id = id;
        this.isbn = isbn;
        this.userId = userId;
        this.borrowDate = borrowDate;
    }

    // Getters/Setters
    public Long getId() { return id; }
    public String getIsbn() { return isbn; }
    public Long getUserId() { return userId; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public LocalDate getReturnDate() { return returnDate; }

    public void markReturned() {
        this.returnDate = LocalDate.now();
    }
}