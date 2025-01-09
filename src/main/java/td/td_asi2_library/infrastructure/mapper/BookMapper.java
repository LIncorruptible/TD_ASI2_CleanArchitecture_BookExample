package td.td_asi2_library.infrastructure.mapper;

import org.springframework.stereotype.Component;
import td.td_asi2_library.domain.entity.Book;
import td.td_asi2_library.infrastructure.entity.BookJpa;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookMapper {

    public Book toDomain(BookJpa toConvert) {
         return new Book(
                 toConvert.getIsbn(),
                 toConvert.getMetadata(),
                 toConvert.getFile()
         );
    }

    public BookJpa toJpa(Book toConvert) {
         BookJpa converted = new BookJpa();
         converted.setIsbn(toConvert.getIsbn());
         converted.setMetadata(toConvert.getMetadata());
         converted.setFile(toConvert.getFile());
         return converted;
    }

    public List<Book> toDomainList(List<BookJpa> toConvert) {
        List<Book> converted = new ArrayList<>();
        for (BookJpa bookJpa : toConvert) {
            converted.add(toDomain(bookJpa));
        }
        return converted;
    }
}
