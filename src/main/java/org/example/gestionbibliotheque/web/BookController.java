package org.example.gestionbibliotheque.web;

import lombok.AllArgsConstructor;
import org.example.gestionbibliotheque.dao.entities.Book;
import org.example.gestionbibliotheque.dao.repositories.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class BookController {
    private final BookRepository bookRepository;

    @GetMapping("/books")
    public String books(Model model,
                        @RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(name = "size", defaultValue = "4") int size,
                        @RequestParam(name = "keyword", defaultValue = "") String kw) {
        Page<Book> pageBooks = bookRepository.findByTitleContainsOrAuthorContains(kw, kw, PageRequest.of(page, size));
        model.addAttribute("ListBooks", pageBooks.getContent());
        model.addAttribute("pages", new int[pageBooks.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", kw);
        model.addAttribute("book", new Book());
        return "books";
    }

    @PostMapping("/books/save")
    public String saveBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/books";
    }

    @GetMapping("/books/delete")
    public String deleteBook(@RequestParam Long id, @RequestParam String keyword, @RequestParam int page) {
        bookRepository.deleteById(id);
        return "redirect:/books?page=" + page + "&keyword=" + keyword;
    }

    @GetMapping("/books/edit")
    @ResponseBody
    public Book editBook(@RequestParam Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @PostMapping("/books/edit")
    public String updateBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/books";
    }

    @GetMapping("/books/search")
    public String searchBooks(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        List<Book> books = bookRepository.findByTitleContainsOrAuthorContains(keyword, keyword, PageRequest.of(0, 10)).getContent();
        model.addAttribute("ListBooks", books);
        return "fragments/bookList :: bookList";
    }

    @GetMapping("/booksByCategory")
    public String booksByCategory(Model model, @RequestParam(name = "category") String category) {
        List<Book> books = bookRepository.findByCategoryName(category);
        model.addAttribute("ListBooks", books);
        return "fragments/bookList :: bookList";
    }

    @GetMapping("/")
    public String home(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Page<Book> pageBooks;
        if (keyword.isEmpty()) {
            pageBooks = bookRepository.findAll(PageRequest.of(0, 4));
        } else {
            pageBooks = bookRepository.findByTitleContainsOrAuthorContains(keyword, keyword, PageRequest.of(0, 4));
        }
        model.addAttribute("ListBooks", pageBooks.getContent());
        model.addAttribute("pages", new int[pageBooks.getTotalPages()]);
        model.addAttribute("currentPage", 0);
        model.addAttribute("keyword", keyword);
        model.addAttribute("book", new Book());
        return "home";
    }
}
