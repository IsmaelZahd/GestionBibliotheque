package org.example.gestionbibliotheque.service;

import org.example.gestionbibliotheque.dao.entities.Review;
import org.example.gestionbibliotheque.dao.entities.Review;
import org.example.gestionbibliotheque.dao.entities.Book;
import org.example.gestionbibliotheque.dao.entities.User1;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ReviewService {
    Review saveReview(Review review);
    Review updateReview(Review review);
    void deleteReviewById(Long id);
    void deleteAllReviews();
    Review getReviewById(Long id);
    List<Review> getAllReviews();
}
