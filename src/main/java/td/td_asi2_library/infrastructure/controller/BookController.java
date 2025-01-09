package td.td_asi2_library.infrastructure.controller;

import org.springframework.web.bind.annotation.*;
import td.td_asi2_library.domain.entity.Book;
import td.td_asi2_library.domain.usecase.*;
import td.td_asi2_library.infrastructure.dto.BookRequestDto;
import td.td_asi2_library.infrastructure.dto.BookResponseDto;
import td.td_asi2_library.infrastructure.mapper.BookMapper;
import td.td_asi2_library.infrastructure.repository.adapter.BookRepositoryAdapter;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    private final CreateBookUseCase createBookUseCase;
    private final DeleteBookUseCase deleteBookUseCase;
    private final GetAllBookUseCase getAllBookUseCase;
    private final GetByIsbnBookUseCase getByIsbnBookUseCase;
    private final BookRepositoryAdapter bookRepositoryAdapter;
    private final EditBookUseCase editBookUseCase;
    private final BookMapper bookMapper;

    public BookController(
            CreateBookUseCase createBookUseCase,
            DeleteBookUseCase deleteBookUseCase,
            GetAllBookUseCase getAllBookUseCase,
            GetByIsbnBookUseCase getByIsbnBookUseCase,
            BookRepositoryAdapter bookRepositoryAdapter,
            EditBookUseCase editBookUseCase,
            BookMapper bookMapper
    ) {
        this.createBookUseCase = createBookUseCase;
        this.deleteBookUseCase = deleteBookUseCase;
        this.getAllBookUseCase = getAllBookUseCase;
        this.getByIsbnBookUseCase = getByIsbnBookUseCase;
        this.bookRepositoryAdapter = bookRepositoryAdapter;
        this.editBookUseCase = editBookUseCase;
        this.bookMapper = bookMapper;
    }

    @GetMapping
    public List<BookResponseDto> getAllBooks() {
        return getAllBookUseCase.execute()
                .stream()
                .map(bookMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/isbn/{isbn}")
    public BookResponseDto getBookByIsbn(@PathVariable String isbn) {
        return bookMapper.toResponseDto(getByIsbnBookUseCase.execute(isbn));
    }

    @PostMapping
    public void createBook(@RequestBody BookRequestDto bookRequestDto) {
        createBookUseCase.execute(bookMapper.toDomain(bookRequestDto));
    }

    @PutMapping
    public void editBook(@RequestBody BookRequestDto[] books) {
        Book oldBook = bookMapper.toDomain(books[0]);
        Book newBook = bookMapper.toDomain(books[1]);
        editBookUseCase.execute(oldBook, newBook);
    }

    @DeleteMapping("/isbn/{isbn}")
    public void deleteBook(@PathVariable String isbn) {
        deleteBookUseCase.execute(isbn);
    }

    @GetMapping("/id/{id}")
    public BookResponseDto getBookById(@PathVariable String id) {
        return bookMapper.toResponseDto(bookRepositoryAdapter.getById(id));
    }
}