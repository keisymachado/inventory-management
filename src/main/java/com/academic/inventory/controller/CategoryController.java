package com.academic.inventory.controller;
import com.academic.inventory.entities.Category;
import com.academic.inventory.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/categories/{id}")
    public Category findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PostMapping("/categories")
    public Category save(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @PutMapping("/categories/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category category) {
        return categoryService.update(id, category);
    }

    @DeleteMapping("/categories/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.deleteById(id);
    }
}