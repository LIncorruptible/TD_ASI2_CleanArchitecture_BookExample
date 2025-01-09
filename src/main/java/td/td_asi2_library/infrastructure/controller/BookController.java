package td.td_asi2_library.infrastructure.controller;

import org.springframework.web.bind.annotation.*;
import td.td_asi2_library.domain.entity.Book;
import td.td_asi2_library.domain.usecase.*;
import td.td_asi2_library.infrastructure.repository.adapter.BookRepositoryAdapter;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final CreateBookUseCase createBookUseCase;
    private final DeleteBookUseCase deleteBookUseCase;
    private final GetAllBookUseCase getAllBookUseCase;
    private final GetByIsbnBookUseCase getByIsbnBookUseCase;
    private final BookRepositoryAdapter bookRepositoryAdapter;
    private final EditBookUseCase editBookUseCase;

    public BookController(CreateBookUseCase createBookUseCase, DeleteBookUseCase deleteBookUseCase, GetAllBookUseCase getAllBookUseCase, GetByIsbnBookUseCase getByIsbnBookUseCase, BookRepositoryAdapter bookRepositoryAdapter, EditBookUseCase editBookUseCase) {
        this.createBookUseCase = createBookUseCase;
        this.deleteBookUseCase = deleteBookUseCase;
        this.getAllBookUseCase = getAllBookUseCase;
        this.getByIsbnBookUseCase = getByIsbnBookUseCase;
        this.bookRepositoryAdapter = bookRepositoryAdapter;
        this.editBookUseCase = editBookUseCase;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return getAllBookUseCase.execute();
    }

    @GetMapping("/isbn/{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn) {
        return getByIsbnBookUseCase.execute(isbn);
    }

    @PostMapping
    public void createBook(@RequestBody Book book) {
        createBookUseCase.execute(book);
    }

    @PutMapping
    public void editBook(
            @RequestBody Book[] books // oldBook, newBook
    ) {
        editBookUseCase.execute(books[0], books[1]);
    }

    @DeleteMapping("/isbn/{isbn}")
    public void deleteBook(@PathVariable String isbn) {
        deleteBookUseCase.execute(isbn);
    }

    @GetMapping("/id/{id}")
    public Book getBookById(@PathVariable String id) {
        return bookRepositoryAdapter.getById(id);
    }
}