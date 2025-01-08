package td.td_asi2_library.domain.repository_port;

import td.td_asi2_library.domain.entity.Book;

import java.util.Optional;
import java.util.List;

public interface BookRepositoryPort {
    Book save(Book book);
    Optional<Book> findByIsbn(String isbn);
    List<Book> findAll();
}