package td.td_asi2_library.infrastructure.repository.adapter;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import td.td_asi2_library.domain.entity.Book;
import td.td_asi2_library.domain.port.BookRepositoryPort;
import td.td_asi2_library.infrastructure.mapper.BookMapper;
import td.td_asi2_library.infrastructure.repository.jpa.BookRepositoryJpa;

import java.util.List;

@Repository
public class BookRepositoryAdapter implements BookRepositoryPort {
    private final BookRepositoryJpa bookRepositoryJpa;
    private final BookMapper bookMapper;

    public BookRepositoryAdapter(BookRepositoryJpa bookRepositoryJpa, BookMapper bookMapper) {
        this.bookRepositoryJpa = bookRepositoryJpa;
        this.bookMapper = bookMapper;
    }

    @Override
    public void save(Book book) {
        bookRepositoryJpa.save(bookMapper.toJpa(book));
    }

    @Override
    public void deleteByIsbn(String isbn) {
        bookRepositoryJpa.deleteByIsbn(isbn);
    }

    @Override
    public Book getByIsbn(String isbn) {
        return bookMapper.toDomain(bookRepositoryJpa.getByIsbn(isbn));
    }

    @Override
    public List<Book> getAll() {
        return bookMapper.toDomainList(bookRepositoryJpa.getAll());
    }

    @Override
    public boolean existingByIsbn(String isbn) {
        return bookRepositoryJpa.existingByIsbn(isbn);
    }

    // Outside of the BookRepositoryPort interface
    public Book getById(String id) {
        return bookMapper.toDomain(bookRepositoryJpa.getById(id));
    }
}
