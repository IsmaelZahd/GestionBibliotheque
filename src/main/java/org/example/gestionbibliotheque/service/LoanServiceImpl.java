package org.example.gestionbibliotheque.service;

import lombok.AllArgsConstructor;
import org.example.gestionbibliotheque.dao.entities.Loan;
import org.example.gestionbibliotheque.dao.entities.Loan;
import org.example.gestionbibliotheque.dao.entities.User1;
import org.example.gestionbibliotheque.dao.repositories.LoanRepository;
import org.example.gestionbibliotheque.dao.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
public class LoanServiceImpl implements LoanService {

    private LoanRepository loanRepository;
    @Override
    public Loan saveLoan(Loan loan) {
        return loanRepository.save(loan);
    }

   /* @Override
    public Loan saveLoan(Loan loan) {
        return null;
    }*/

    @Override
    public Loan updateLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public void deleteLoanById(Long id) {
        loanRepository.deleteById(id);
    }

    @Override
    public void deleteAllLoans() {
        loanRepository.deleteAll();
    }

    @Override
    public Loan getLoanById(Long id) {
        return loanRepository.findById(id).get();
    }

    @Override
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }
}
