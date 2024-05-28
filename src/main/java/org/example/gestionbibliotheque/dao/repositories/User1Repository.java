package org.example.gestionbibliotheque.dao.repositories;

import org.example.gestionbibliotheque.dao.entities.User1;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface User1Repository extends JpaRepository<User1, Long> {

    Page<User1> findByUsernameContainsOrEmailContains(String usernameKeyword, String emailKeyword, Pageable pageable);
    Optional<User1> findByUsername(String username);
}

