package org.example.gestionbibliotheque.dao.repositories;

import org.example.gestionbibliotheque.dao.entities.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findByBookTitleContains(String title, Pageable pageable);
}
