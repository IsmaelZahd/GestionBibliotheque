package org.example.gestionbibliotheque.web;

import lombok.AllArgsConstructor;
import org.example.gestionbibliotheque.dao.entities.Loan;
import org.example.gestionbibliotheque.dao.repositories.LoanRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class LoanController {
    private final LoanRepository loanRepository;

    @GetMapping("/loans")
    public String index(Model model,
                        @RequestParam(name="page",defaultValue="0") int page,
                        @RequestParam(name="size",defaultValue="4")int size,
                        @RequestParam(name = "keyword",defaultValue = "")String kw
    ){
        Page<Loan> pageLoans = loanRepository.findByUser1UsernameContainsOrBookTitleContains(kw, kw, PageRequest.of(page, size));
        model.addAttribute("ListLoans", pageLoans.getContent());
        model.addAttribute("pages", new int[pageLoans.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", kw);
        return "loans";
    }

    @GetMapping("/loans/delete")
    public String delete(Long id, String keyword, int page){
        loanRepository.deleteById(id);
        return "redirect:/loans?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/loans/add")
    public String addLoan(){
        // Add logic for adding a loan
        return "redirect:/loans"; // Redirect back to the loans page after adding
    }

}
