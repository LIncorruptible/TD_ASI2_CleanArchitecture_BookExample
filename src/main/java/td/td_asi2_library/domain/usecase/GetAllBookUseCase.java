package td.td_asi2_library.domain.usecase;

import td.td_asi2_library.domain.entity.Book;
import td.td_asi2_library.domain.port.BookRepositoryPort;

import java.util.List;

public class GetAllBookUseCase {
    private final BookRepositoryPort bookRepositoryPort;

    public GetAllBookUseCase(BookRepositoryPort bookRepositoryPort) {
        this.bookRepositoryPort = bookRepositoryPort;
    }

    public List<Book> execute() {
        List<Book> books = bookRepositoryPort.getAll();
        // Controls
        if (books.isEmpty()) {
            throw new IllegalArgumentException("No books found");
        }
        return books;
    }
}
