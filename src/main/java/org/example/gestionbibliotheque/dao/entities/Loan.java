package org.example.gestionbibliotheque.dao.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "loans")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate loanDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private Double loanPrice;

    @ManyToOne
    @JoinColumn(name = "user1",nullable = false)
    private User1 user1;

    @ManyToOne
    @JoinColumn(name = "book",nullable = false)
    private Book book;

}
