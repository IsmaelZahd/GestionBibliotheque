package org.example.gestionbibliotheque.service;

import org.example.gestionbibliotheque.dao.entities.Book;
import org.example.gestionbibliotheque.dao.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    Book saveBook(Book book);
    Book updateBook(Book book);
    void deleteBookById(Long id);
    void deleteAllBooks();
    Book getBookById(Long id);



    List<Book> getAllBooks();
}
