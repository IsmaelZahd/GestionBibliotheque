package org.example.gestionbibliotheque.service;

import lombok.AllArgsConstructor;
import org.example.gestionbibliotheque.dao.entities.Reservation;
import org.example.gestionbibliotheque.dao.entities.Reservation;
import org.example.gestionbibliotheque.dao.entities.Book;
import org.example.gestionbibliotheque.dao.entities.User1;
import org.example.gestionbibliotheque.dao.repositories.ReservationRepository;
import org.example.gestionbibliotheque.dao.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private ReservationRepository reservationRepository;
    @Override
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

   /* @Override
    public Reservation saveReservation(Reservation reservation) {
        return null;
    }*/

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservationById(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public void deleteAllReservations() {
        reservationRepository.deleteAll();
    }

    @Override
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).get();
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}
