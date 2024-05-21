package org.example.gestionbibliotheque.service;

import lombok.AllArgsConstructor;
import org.example.gestionbibliotheque.dao.entities.Review;
import org.example.gestionbibliotheque.dao.entities.Review;
import org.example.gestionbibliotheque.dao.entities.Book;
import org.example.gestionbibliotheque.dao.entities.User1;
import org.example.gestionbibliotheque.dao.repositories.ReviewRepository;
import org.example.gestionbibliotheque.dao.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    @Override
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

   /* @Override
    public Review saveReview(Review review) {
        return null;
    }*/

    @Override
    public Review updateReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public void deleteReviewById(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public void deleteAllReviews() {
        reviewRepository.deleteAll();
    }

    @Override
    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).get();
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }
}
