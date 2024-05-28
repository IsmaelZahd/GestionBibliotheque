package org.example.gestionbibliotheque.dao.repositories;

import org.example.gestionbibliotheque.dao.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Page<Book> findByTitleContainsOrAuthorContains(String titleKeyword, String authorKeyword, Pageable pageable);
    List<Book> findByCategoryName(String categoryName);
    @Query("SELECT b FROM Book b WHERE b.title LIKE %:keyword% OR b.author LIKE %:keyword%")
    Page<Book> search(@Param("keyword") String keyword, Pageable pageable);
}
