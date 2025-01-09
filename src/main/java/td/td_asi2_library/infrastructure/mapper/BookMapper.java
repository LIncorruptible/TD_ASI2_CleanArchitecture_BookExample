package td.td_asi2_library.infrastructure.mapper;

import org.springframework.stereotype.Component;
import td.td_asi2_library.domain.entity.Book;
import td.td_asi2_library.infrastructure.dto.BookRequestDto;
import td.td_asi2_library.infrastructure.dto.BookResponseDto;
import td.td_asi2_library.infrastructure.entity.BookJpa;

import java.util.List;

@Component
public class BookMapper {

    // JPA -> Domain
    public Book toDomain(BookJpa bookJpa) {
        if (bookJpa == null) {
            return null;
        }
        return new Book(
                bookJpa.getIsbn(),
                bookJpa.getMetadata(),
                bookJpa.getFile()
        );
    }

    public List<Book> toDomainList(List<BookJpa> bookJpaList) {
        if (bookJpaList == null) {
            return List.of(); // Retourne une liste vide si null
        }
        return bookJpaList.stream()
                .map(this::toDomain)
                .toList();
    }

    // Domain -> JPA
    public BookJpa toJpa(Book book) {
        if (book == null) {
            return null;
        }
        BookJpa bookJpa = new BookJpa();
        bookJpa.setIsbn(book.getIsbn());
        bookJpa.setMetadata(book.getMetadata());
        bookJpa.setFile(book.getFile());
        return bookJpa;
    }

    // Request DTO -> Domain
    public Book toDomain(BookRequestDto requestDto) {
        if (requestDto == null) {
            return null;
        }
        return new Book(
                requestDto.getIsbn(),
                requestDto.getMetadata(),
                requestDto.getFile()
        );
    }

    // Domain -> Response DTO
    public BookResponseDto toResponseDto(Book book) {
        if (book == null) {
            return null;
        }
        return new BookResponseDto(
                book.getIsbn(),
                book.getMetadata(),
                book.getFile()
        );
    }
}