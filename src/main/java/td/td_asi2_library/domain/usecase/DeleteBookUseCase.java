package td.td_asi2_library.domain.usecase;

import td.td_asi2_library.domain.entity.Book;
import td.td_asi2_library.domain.port.BookRepositoryPort;

public class DeleteBookUseCase {
    // Attributes
    private final BookRepositoryPort bookRepositoryPort;

    // Constructor
    public DeleteBookUseCase(BookRepositoryPort bookRepositoryPort) {
        this.bookRepositoryPort = bookRepositoryPort;
    }

    // Methods
    public void execute(String isbn) {
        // Controls
        if (!bookRepositoryPort.existingByIsbn(isbn)) {
            throw new IllegalArgumentException("Book does not exist");
        }
        bookRepositoryPort.deleteByIsbn(isbn);
    }
}
