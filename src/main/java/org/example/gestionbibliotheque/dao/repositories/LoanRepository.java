package org.example.gestionbibliotheque.dao.repositories;

import org.example.gestionbibliotheque.dao.entities.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    Page<Loan> findByUser1UsernameContainsOrBookTitleContains(String userNameKeyword, String bookTitleKeyword, Pageable pageable);

    @Query("SELECT l FROM Loan l WHERE l.user1.username LIKE %:keyword% OR l.book.title LIKE %:keyword%")
    Page<Loan> search(@Param("keyword") String keyword, Pageable pageable);


}
