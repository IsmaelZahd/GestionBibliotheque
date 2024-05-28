package org.example.gestionbibliotheque.service;

import lombok.AllArgsConstructor;
import org.example.gestionbibliotheque.dao.entities.Book;
import org.example.gestionbibliotheque.dao.repositories.BookRepository;

import java.util.List;

@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

   /* @Override
    public Book saveBook(Book book) {
        return null;
    }*/

    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void deleteAllBooks() {
        bookRepository.deleteAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).get();
    }


    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
