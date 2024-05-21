package org.example.gestionbibliotheque.service;

import org.example.gestionbibliotheque.dao.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    Category saveCategory(Category book);
    Category updateCategory(Category book);
    void deleteCategoryById(Long id);
    void deleteAllCategories();
    Category getCategoryById(Long id);
    List<Category> getAllCategories();
}
