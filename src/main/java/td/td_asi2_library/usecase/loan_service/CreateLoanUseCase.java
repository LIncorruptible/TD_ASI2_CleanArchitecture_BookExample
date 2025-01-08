package td.td_asi2_library.usecase.loan_service;

import td.td_asi2_library.domain.entity.Loan;
import td.td_asi2_library.domain.repository_port.LoanRepositoryPort;

import java.util.List;

public class CreateLoanUseCase {
    private final LoanRepositoryPort loanRepository;

    public CreateLoanUseCase(LoanRepositoryPort loanRepository) {
        this.loanRepository = loanRepository;
    }

    public Loan createLoan(String isbn, Long userId) {
        // Vérifier que l'utilisateur n'a pas déjà emprunté ce livre
        List<Loan> loans = loanRepository.findByUserId(userId);
        for (Loan loan : loans) {
            if (loan.getIsbn().equals(isbn) && loan.getReturnDate() != null) {
                throw new IllegalArgumentException("User already borrowed this book");
            }
        }
        // Vérifier que le livre est disponible
        List<Loan> loans2 = loanRepository.findByIsbn(isbn);
        for (Loan loan : loans2) {
            if (loan.getReturnDate() != null) {
                throw new IllegalArgumentException("Book already borrowed");
            }
        }
        // Créer l'entité Loan
        Loan newLoan = new Loan(isbn, userId);
        // Sauvegarder l'entité Loan via le port
        return loanRepository.save(newLoan);
    }
}
