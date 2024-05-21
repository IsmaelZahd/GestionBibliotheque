package org.example.gestionbibliotheque.service;

import lombok.AllArgsConstructor;
import org.example.gestionbibliotheque.dao.entities.Category;
import org.example.gestionbibliotheque.dao.entities.Category;
import org.example.gestionbibliotheque.dao.repositories.CategoryRepository;
import org.example.gestionbibliotheque.dao.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {


    private CategoryRepository categoryRepository;
    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

   /* @Override
    public Category saveCategory(Category category) {
        return null;
    }*/

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void deleteAllCategories() {
        categoryRepository.deleteAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
