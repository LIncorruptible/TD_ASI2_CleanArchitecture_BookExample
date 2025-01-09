package td.td_asi2_library.infrastructure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import td.td_asi2_library.domain.usecase.GetAllBookUseCase;
import td.td_asi2_library.infrastructure.presenter.BookPresenter;

@Controller
@RequestMapping("/books")
public class BookViewController {

    private final GetAllBookUseCase getAllBookUseCase;
    private final BookPresenter bookPresenter;

    public BookViewController(GetAllBookUseCase getAllBookUseCase, BookPresenter bookPresenter) {
        this.getAllBookUseCase = getAllBookUseCase;
        this.bookPresenter = bookPresenter;
    }

    @GetMapping("/list")
    public String listBooks(Model model) {
        model.addAttribute("books", bookPresenter.prepareListView(getAllBookUseCase.execute()));
        return "book-list"; // Renvoie vers le fichier book-list.html
    }
}