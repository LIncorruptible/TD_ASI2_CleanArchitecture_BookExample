package td.td_asi2_library.usecase;

import td.td_asi2_library.domain.entity.Book;
import td.td_asi2_library.domain.entity.Loan;
import td.td_asi2_library.domain.repository_port.BookRepositoryPort;
import td.td_asi2_library.domain.repository_port.LoanRepositoryPort;
import td.td_asi2_library.domain.repository_port.UserRepositoryPort;

import java.time.LocalDate;

public class BorrowBookUseCase {
    private final BookRepositoryPort bookRepository;
    private final UserRepositoryPort userRepository;
    private final LoanRepositoryPort loanRepository;

    public BorrowBookUseCase(BookRepositoryPort bookRepo,
                             UserRepositoryPort userRepo,
                             LoanRepositoryPort loanRepo) {
        this.bookRepository = bookRepo;
        this.userRepository = userRepo;
        this.loanRepository = loanRepo;
    }

    public Loan execute(String isbn, Long userId) {
        // Vérifier que le livre existe
        Book book = bookRepository.findByIsbn(isbn)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (book.isBorrowed()) {
            throw new RuntimeException("Book is already borrowed");
        }

        // Vérifier que l’utilisateur existe
        userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Marquer le livre comme emprunté (côté domaine)
        book.borrow();
        bookRepository.save(book);

        // Créer un prêt (Loan)
        Loan loan = new Loan(null, isbn, userId, LocalDate.now());
        // Enregistrer le prêt
        loanRepository.save(loan);

        return loan;
    }
}