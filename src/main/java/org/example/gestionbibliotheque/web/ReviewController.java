package org.example.gestionbibliotheque.web;

import lombok.AllArgsConstructor;
import org.example.gestionbibliotheque.dao.entities.Review;
import org.example.gestionbibliotheque.dao.repositories.ReviewRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class ReviewController {
    private final ReviewRepository reviewRepository;

    @GetMapping("/reviews")
    public String reviews(Model model,
                          @RequestParam(name = "page", defaultValue = "0") int page,
                          @RequestParam(name = "size", defaultValue = "4") int size,
                          @RequestParam(name = "keyword", defaultValue = "") String kw) {

        Page<Review> pageReviews = reviewRepository.findByBookTitleContains(kw, PageRequest.of(page, size));
        model.addAttribute("ListReviews", pageReviews.getContent());
        model.addAttribute("pages", new int[pageReviews.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", kw);
        return "reviews";
    }

    @PostMapping("/reviews/save")
    public String saveReview(@ModelAttribute Review review) {
        reviewRepository.save(review);
        return "redirect:/reviews";
    }

    @GetMapping("/reviews/delete")
    public String deleteReview(@RequestParam Long id, @RequestParam String keyword, @RequestParam int page) {
        reviewRepository.deleteById(id);
        return "redirect:/reviews?page=" + page + "&keyword=" + keyword;
    }

    @GetMapping("/reviews/edit")
    @ResponseBody
    public Review editReview(@RequestParam Long id) {
        return reviewRepository.findById(id).orElse(null);
    }
}
