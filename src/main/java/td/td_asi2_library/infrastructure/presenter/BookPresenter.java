package td.td_asi2_library.infrastructure.presenter;

import org.springframework.stereotype.Component;
import td.td_asi2_library.infrastructure.dto.BookResponseDto;
import td.td_asi2_library.domain.entity.Book;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookPresenter {

    // Préparer un seul BookResponseDto pour une vue
    public BookResponseDto prepareView(Book book) {
        if (book == null) {
            return null;
        }

        // Prépare les données pour l'affichage
        return new BookResponseDto(
            book.getIsbn(),
            book.getMetadata(),
            "File size: " + (book.getFile() != null ? book.getFile().length() + " bytes" : "No file available")
        );
    }

    // Préparer une liste de BookResponseDto pour une vue
    public List<BookResponseDto> prepareListView(List<Book> books) {
        if (books == null || books.isEmpty()) {
            return List.of(); // Retourne une liste vide pour éviter les erreurs
        }

        return books.stream()
                    .map(this::prepareView)
                    .collect(Collectors.toList());
    }
}