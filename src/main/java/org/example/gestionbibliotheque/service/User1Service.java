package org.example.gestionbibliotheque.service;

import org.example.gestionbibliotheque.dao.entities.User1;
import org.example.gestionbibliotheque.dao.entities.User1;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface User1Service {
    User1 saveUser1(User1 user1);
    User1 updateUser1(User1 user1);
    void deleteUser1ById(Long id);
    void deleteAllUser1s();
    User1 getUser1ById(Long id);
    List<User1> getAllUser1s();

}
