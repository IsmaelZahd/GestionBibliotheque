package org.example.gestionbibliotheque.dao.repositories;

import org.example.gestionbibliotheque.dao.entities.Reservation;
import org.example.gestionbibliotheque.dao.entities.Book;
import org.example.gestionbibliotheque.dao.entities.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
   /* List<Reservation> findByUser(User1 user);
    List<Reservation> findByBook(Book book);
    List<Reservation> findByStatus(String status);*/
}
