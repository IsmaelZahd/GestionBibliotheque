package org.example.gestionbibliotheque.dao.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.*;

@Entity
@Table(name = "user1s")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String username;
    private String password;
    private String email;
    private String fullName;
    private String role;
    private LocalDate membershipStartDate;

    @OneToMany(mappedBy = "user1", fetch = FetchType.LAZY)
    private List<Reservation> reservations = new ArrayList<>();

    @OneToMany(mappedBy = "user1", fetch = FetchType.LAZY)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "user1", fetch = FetchType.LAZY)
    private List<Loan> loans = new ArrayList<>();
}
