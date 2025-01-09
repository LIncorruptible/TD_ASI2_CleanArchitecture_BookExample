package td.td_asi2_library.domain.usecase;

import td.td_asi2_library.domain.entity.Book;
import td.td_asi2_library.domain.port.BookRepositoryPort;

public class GetByIsbnBookUseCase {
    private final BookRepositoryPort bookRepositoryPort;

    public GetByIsbnBookUseCase(BookRepositoryPort bookRepositoryPort) {
        this.bookRepositoryPort = bookRepositoryPort;
    }

    public Book execute(String isbn) {
        Book book = bookRepositoryPort.getByIsbn(isbn);
        // Controls
        if (book == null) {
            throw new IllegalArgumentException("Book not found");
        }
        return book;
    }
}
