package org.example.gestionbibliotheque.web;

import lombok.AllArgsConstructor;
import org.example.gestionbibliotheque.dao.entities.Book;
import org.example.gestionbibliotheque.dao.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class BookController {
    private BookRepository bookRepository;
    @GetMapping("/index")

    public String index(Model model){
        List<Book> bookList=bookRepository.findAll();
        model.addAttribute("ListBooks",bookList);

        return "books";
    }
}
