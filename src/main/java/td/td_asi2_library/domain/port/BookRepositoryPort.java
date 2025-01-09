package td.td_asi2_library.domain.port;

import td.td_asi2_library.domain.entity.Book;

import java.util.List;

public interface BookRepositoryPort {
    void save(Book book);
    void deleteByIsbn(String isbn);

    Book getByIsbn(String isbn);
    List<Book> getAll();

    boolean existingByIsbn(String isbn);
}
