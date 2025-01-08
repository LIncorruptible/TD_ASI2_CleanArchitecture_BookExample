package td.td_asi2_library.domain.repository_port;

import td.td_asi2_library.domain.entity.Loan;

import java.util.Optional;
import java.util.List;

public interface LoanRepositoryPort {
    Loan save(Loan loan);
    Optional<Loan> findById(Long id);
    List<Loan> findByUserId(Long userId);
    List<Loan> findByIsbn(String isbn);
}