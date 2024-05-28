package org.example.gestionbibliotheque.dao.repositories;

import org.example.gestionbibliotheque.dao.entities.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Page<Reservation> findByUser1UsernameContainsOrBookTitleContains(String userNameKeyword, String bookTitleKeyword, Pageable pageable);

    @Query("SELECT r FROM Reservation r WHERE r.user1.username LIKE %:keyword% OR r.book.title LIKE %:keyword%")
    Page<Reservation> search(@Param("keyword") String keyword, Pageable pageable);

}
