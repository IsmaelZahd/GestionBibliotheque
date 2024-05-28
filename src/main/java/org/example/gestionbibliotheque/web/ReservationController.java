package org.example.gestionbibliotheque.web;

import lombok.AllArgsConstructor;
import org.example.gestionbibliotheque.dao.entities.Reservation;
import org.example.gestionbibliotheque.dao.repositories.ReservationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class ReservationController {
    private final ReservationRepository reservationRepository;

    @GetMapping("/reservations")
    public String reservations(Model model,
                               @RequestParam(name = "page", defaultValue = "0") int page,
                               @RequestParam(name = "size", defaultValue = "4") int size,
                               @RequestParam(name = "keyword", defaultValue = "") String kw) {

        Page<Reservation> pageReservations = reservationRepository.findByUser1UsernameContainsOrBookTitleContains(kw, kw, PageRequest.of(page, size));
        model.addAttribute("ListReservations", pageReservations.getContent());
        model.addAttribute("pages", new int[pageReservations.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", kw);
        model.addAttribute("reservation", new Reservation());
        return "reservations";
    }

    @PostMapping("/reservations/save")
    public String saveReservation(@ModelAttribute Reservation reservation) {
        reservationRepository.save(reservation);
        return "redirect:/reservations";
    }

    @GetMapping("/reservations/delete")
    public String deleteReservation(@RequestParam Long id, @RequestParam String keyword, @RequestParam int page) {
        reservationRepository.deleteById(id);
        return "redirect:/reservations?page=" + page + "&keyword=" + keyword;
    }

    @GetMapping("/reservations/edit")
    @ResponseBody
    public Reservation editReservation(@RequestParam Long id) {
        return reservationRepository.findById(id).orElse(null);
    }
}
