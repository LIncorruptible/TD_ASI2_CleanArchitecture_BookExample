package td.td_asi2_library.usecase.book_service;

import td.td_asi2_library.domain.repository_port.BookRepositoryPort;

public class DeleteBookUseCase {
    private final BookRepositoryPort bookRepository;

    public DeleteBookUseCase(BookRepositoryPort bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Boolean execute(String isbn) {
        // Vérifier si le livre existe
        if (bookRepository.findByIsbn(isbn) == null) {
            throw new RuntimeException("Book not found with ISBN " + isbn);
        }
        // Supprimer via le port
        return bookRepository.delete(isbn);
    }
}
