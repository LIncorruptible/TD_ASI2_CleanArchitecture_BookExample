package td.td_asi2_library.domain.usecase;

import td.td_asi2_library.domain.entity.Book;
import td.td_asi2_library.domain.port.BookRepositoryPort;

public class EditBookUseCase {
    // Attributes
    private final BookRepositoryPort bookRepositoryPort;

    // Constructor
    public EditBookUseCase(BookRepositoryPort bookRepositoryPort) {
        this.bookRepositoryPort = bookRepositoryPort;
    }

    // Methods
    public void execute(Book oldBook, Book updatedBook) {
        // Validation
        if (!updatedBook.isValid()) {
            throw new IllegalArgumentException("Book is not valid");
        }
        // Controls
        if (oldBook.equals(updatedBook)) {
            throw new IllegalArgumentException("Book is the same");
        }
        if (!bookRepositoryPort.existingByIsbn(oldBook.getIsbn())) {
            throw new IllegalArgumentException("Book does not exist");
        }
        if (bookRepositoryPort.existingByIsbn(updatedBook.getIsbn())) {
            throw new IllegalArgumentException("Book already exists");
        }
        // Save
        bookRepositoryPort.update(oldBook.getIsbn(), updatedBook);
    }
}
