package td.td_asi2_library.usecase.loan_service;

import td.td_asi2_library.domain.entity.Loan;
import td.td_asi2_library.domain.repository_port.LoanRepositoryPort;

import java.util.List;

public class ListLoanUseCase {
    private final LoanRepositoryPort loanRepositoryPort;

    public ListLoanUseCase(LoanRepositoryPort loanRepositoryPort) {
        this.loanRepositoryPort = loanRepositoryPort;
    }

    public List<Loan> listAll() {
        return loanRepositoryPort.findAll();
    }
}
