package td.td_asi2_library.usecase.book_service;

import td.td_asi2_library.domain.entity.Loan;
import td.td_asi2_library.domain.repository_port.BookRepositoryPort;

import java.time.LocalDate;

public class BorrowBookUseCase {
    private final BookRepositoryPort bookRepository;

    public BorrowBookUseCase(BookRepositoryPort bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Loan execute(String isbn, Long borrower) {
        // Vérifier si le livre existe
        if (bookRepository.findByIsbn(isbn) == null) {
            throw new RuntimeException("Book not found with ISBN " + isbn);
        }
        // Vérifier si le livre est disponible
        if (!bookRepository.findByIsbn(isbn).isBorrowed()) {
            throw new RuntimeException("Book not available with ISBN " + isbn);
        }
        // Emprunter le livre
        bookRepository.findByIsbn(isbn).borrow();
        // Créer l’entité Loan
        return new Loan(
                null,
                isbn,
                borrower,
                LocalDate.now()
        );
    }
}
