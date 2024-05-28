package org.example.gestionbibliotheque.web;

import lombok.AllArgsConstructor;
import org.example.gestionbibliotheque.dao.entities.User1;
import org.example.gestionbibliotheque.dao.repositories.User1Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class User1Controller {
    private final User1Repository user1Repository;

    @GetMapping("/user1s")
    public String user1s(Model model,
                        @RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(name = "size", defaultValue = "4") int size,
                        @RequestParam(name = "keyword", defaultValue = "") String kw) {

        Page<User1> pageUsers = user1Repository.findByUsernameContainsOrEmailContains(kw, kw, PageRequest.of(page, size));
        model.addAttribute("ListUsers", pageUsers.getContent());
        model.addAttribute("pages", new int[pageUsers.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", kw);
        model.addAttribute("user1", new User1());
        return "user1s";
    }

    @PostMapping("/user1s/save")
    public String saveUser(@ModelAttribute User1 user1) {
        user1Repository.save(user1);
        return "redirect:/user1s";
    }

    @GetMapping("/user1s/delete")
    public String deleteUser(@RequestParam Long id, @RequestParam String keyword, @RequestParam int page) {
        user1Repository.deleteById(id);
        return "redirect:/user1s?page=" + page + "&keyword=" + keyword;
    }

    @GetMapping("/user1s/edit")
    @ResponseBody
    public User1 editUser(@RequestParam Long id) {
        return user1Repository.findById(id).orElse(null);
    }
}
