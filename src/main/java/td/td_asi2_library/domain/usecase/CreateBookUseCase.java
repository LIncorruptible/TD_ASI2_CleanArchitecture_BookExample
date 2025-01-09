package td.td_asi2_library.domain.usecase;

import td.td_asi2_library.domain.entity.Book;
import td.td_asi2_library.domain.port.BookRepositoryPort;

public class CreateBookUseCase {
    // Attributes
    private final BookRepositoryPort bookRepositoryPort;

    // Constructor
    public CreateBookUseCase(BookRepositoryPort bookRepositoryPort) {
        this.bookRepositoryPort = bookRepositoryPort;
    }

    // Methods
    public void execute(Book book) {
        Book newBook = new Book(
                book.getIsbn(),
                book.getMetadata(),
                book.getFile()
        );

        // Validation
        if (!newBook.isValid()) {
            throw new IllegalArgumentException("Book is not valid");
        }

        // Controls
        if (bookRepositoryPort.existingByIsbn(book.getIsbn())) {
            throw new IllegalArgumentException("Book already exists");
        }

        bookRepositoryPort.save(newBook);
    }
}