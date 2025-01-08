package td.td_asi2_library.usecase.loan_service;

import td.td_asi2_library.domain.repository_port.LoanRepositoryPort;

public class DeleteLoanUseCase {
    private final LoanRepositoryPort loanRepository;

    public DeleteLoanUseCase(LoanRepositoryPort loanRepository) {
        this.loanRepository = loanRepository;
    }

    public Boolean deleteLoan(Long loanId) {
        // Vérifier que le prêt existe
        if (loanRepository.findById(loanId) == null) {
            throw new IllegalArgumentException("Loan not found");
        }
        // Supprimer l'entité Loan via le port
        return loanRepository.delete(loanId);
    }
}
