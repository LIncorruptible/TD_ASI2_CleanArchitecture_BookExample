package td.td_asi2_library.usecase.book_service;

import td.td_asi2_library.domain.entity.Book;
import td.td_asi2_library.domain.repository_port.BookRepositoryPort;

import java.util.List;

public class ListBookUseCase {
    private final BookRepositoryPort bookRepositoryPort;

    public ListBookUseCase(BookRepositoryPort bookRepositoryPort) {
        this.bookRepositoryPort = bookRepositoryPort;
    }

    public List<Book> execute() {
        return bookRepositoryPort.findAll();
    }
}
