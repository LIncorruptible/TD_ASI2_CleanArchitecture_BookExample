package td.td_asi2_library.usecase.loan_service;

import td.td_asi2_library.domain.entity.Loan;
import td.td_asi2_library.domain.repository_port.LoanRepositoryPort;

public class ReturnMarkLoanUseCase {
    private final LoanRepositoryPort loanRepositoryPort;

    public ReturnMarkLoanUseCase(LoanRepositoryPort loanRepositoryPort) {
        this.loanRepositoryPort = loanRepositoryPort;
    }

    public void markReturned(Long loanId) {
        // Récupération du prêt
        Loan loan = loanRepositoryPort.findById(loanId);
        // Vérification de l'existence du prêt
        if (loan == null) {
            throw new IllegalArgumentException("Loan not found");
        }
        // Marquage du prêt comme rendu
        loan.markReturned();
        // Mise à jour du prêt
        loanRepositoryPort.save(loan);
    }
}
