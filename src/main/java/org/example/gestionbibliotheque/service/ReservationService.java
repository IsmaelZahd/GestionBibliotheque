package org.example.gestionbibliotheque.service;

import org.example.gestionbibliotheque.dao.entities.Reservation;
import org.example.gestionbibliotheque.dao.entities.Reservation;
import org.example.gestionbibliotheque.dao.entities.User1;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ReservationService {
    Reservation saveReservation(Reservation reservation);
    Reservation updateReservation(Reservation reservation);
    void deleteReservationById(Long id);
    void deleteAllReservations();
    Reservation getReservationById(Long id);
    List<Reservation> getAllReservations();
}
