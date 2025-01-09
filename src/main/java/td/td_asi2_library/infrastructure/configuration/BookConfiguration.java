package td.td_asi2_library.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import td.td_asi2_library.domain.port.BookRepositoryPort;
import td.td_asi2_library.domain.usecase.*;

@Configuration
public class BookConfiguration {

    private final BookRepositoryPort bookRepositoryPort;

    public BookConfiguration(BookRepositoryPort bookRepositoryPort) {
        this.bookRepositoryPort = bookRepositoryPort;
    }

    @Bean
    public CreateBookUseCase createBookUseCase() {
        return new CreateBookUseCase(bookRepositoryPort);
    }

    @Bean
    public EditBookUseCase editBookUseCase() { return new EditBookUseCase(bookRepositoryPort); }

    @Bean
    public DeleteBookUseCase deleteBookUseCase() {
        return new DeleteBookUseCase(bookRepositoryPort);
    }

    @Bean
    public GetAllBookUseCase getAllBookUseCase() { return new GetAllBookUseCase(bookRepositoryPort); }

    @Bean
    public GetByIsbnBookUseCase getByIsbnBookUseCase() { return new GetByIsbnBookUseCase(bookRepositoryPort); }
}