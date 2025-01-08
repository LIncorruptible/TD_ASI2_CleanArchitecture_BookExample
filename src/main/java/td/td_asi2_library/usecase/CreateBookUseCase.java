package td.td_asi2_library.usecase;

import td.td_asi2_library.domain.entity.Book;
import td.td_asi2_library.domain.repository_port.BookRepositoryPort;

public class CreateBookUseCase {
    private final BookRepositoryPort bookRepository;

    public CreateBookUseCase(BookRepositoryPort bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book execute(String isbn, String title) {
        // Vérifier si le livre existe déjà
        if (bookRepository.findByIsbn(isbn).isPresent()) {
            throw new RuntimeException("Book already exists with ISBN " + isbn);
        }
        // Créer l’entité Book
        Book newBook = new Book(isbn, title);
        // Sauvegarder via le port
        return bookRepository.save(newBook);
    }
}