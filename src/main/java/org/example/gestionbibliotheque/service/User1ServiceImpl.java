package org.example.gestionbibliotheque.service;

import lombok.AllArgsConstructor;
import org.example.gestionbibliotheque.dao.entities.User1;
import org.example.gestionbibliotheque.dao.entities.User1;
import org.example.gestionbibliotheque.dao.repositories.User1Repository;
import org.example.gestionbibliotheque.dao.repositories.User1Repository;

import java.util.*;
@AllArgsConstructor
public class User1ServiceImpl implements User1Service{

    private User1Repository user1Repository;
    @Override
    public User1 saveUser1(User1 user1) {
        return user1Repository.save(user1);
    }

   /* @Override
    public User1 saveUser1(User1 user1) {
        return null;
    }*/

    @Override
    public User1 updateUser1(User1 user1) {
        return user1Repository.save(user1);
    }

    @Override
    public void deleteUser1ById(Long id) {
        user1Repository.deleteById(id);
    }

    @Override
    public void deleteAllUser1s() {
        user1Repository.deleteAll();
    }

    @Override
    public User1 getUser1ById(Long id) {
        return user1Repository.findById(id).get();
    }

    @Override
    public List<User1> getAllUser1s() {
        return user1Repository.findAll();
    }
}
