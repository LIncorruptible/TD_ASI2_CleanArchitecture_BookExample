package td.td_asi2_library.usecase.book_service;

import td.td_asi2_library.domain.entity.Book;
import td.td_asi2_library.domain.repository_port.BookRepositoryPort;

public class ReturnBookUseCase {
    private final BookRepositoryPort bookRepository;

    public ReturnBookUseCase(BookRepositoryPort bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void execute(String isbn) {
        Book book = bookRepository.findByIsbn(isbn);
        // Vérifier si le livre existe
        if (book == null) {
            throw new RuntimeException("Book not found with ISBN " + isbn);
        }
        // Vérifier si le livre est emprunté
        if (!book.isBorrowed()) {
            throw new RuntimeException("Book not borrowed with ISBN " + isbn);
        }
        // Retourner le livre
        book.returnBook();
        // Mettre à jour le livre
        bookRepository.save(book);
    }
}
