package org.example.gestionbibliotheque.service;

import org.example.gestionbibliotheque.dao.entities.Loan;
import org.example.gestionbibliotheque.dao.entities.Loan;
import org.example.gestionbibliotheque.dao.entities.User1;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public interface LoanService {
    Loan saveLoan(Loan loan);
    Loan updateLoan(Loan loan);
    void deleteLoanById(Long id);
    void deleteAllLoans();
    Loan getLoanById(Long id);
    List<Loan> getAllLoans();
}
