package org.example.gestionbibliotheque.web;

import lombok.AllArgsConstructor;
import org.example.gestionbibliotheque.dao.entities.Category;
import org.springframework.data.domain.PageRequest;
import org.example.gestionbibliotheque.dao.repositories.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Controller
@AllArgsConstructor
public class CategoryController {
    private final CategoryRepository categoryRepository;
    private final Logger logger = Logger.getLogger(CategoryController.class.getName());

    @GetMapping("/categories")
    public String categories(Model model,
                             @RequestParam(name = "page", defaultValue = "0") int page,
                             @RequestParam(name = "size", defaultValue = "4") int size,
                             @RequestParam(name = "keyword", defaultValue = "") String kw) {
        Page<Category> pageCategories = categoryRepository.findByNameContains(kw, PageRequest.of(page, size));
        model.addAttribute("ListCategories", pageCategories.getContent());
        model.addAttribute("pages", new int[pageCategories.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", kw);
        model.addAttribute("category", new Category());
        return "categories";
    }

    @PostMapping("/categories/save")
    public String saveCategory(@ModelAttribute Category category) {
        categoryRepository.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories/delete")
    public String deleteCategory(@RequestParam Long id, @RequestParam String keyword, @RequestParam int page) {
        categoryRepository.deleteById(id);
        return "redirect:/categories?page=" + page + "&keyword=" + keyword;
    }

    @GetMapping("/categories/edit")
    @ResponseBody
    public Category editCategory(@RequestParam Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @GetMapping("/categories/list")
    @ResponseBody
    public List<Category> listCategories() {
        List<Category> categories = categoryRepository.findAll();
        categories.forEach(category -> logger.info("Category: " + category.getName()));
        return categories;
    }
}
