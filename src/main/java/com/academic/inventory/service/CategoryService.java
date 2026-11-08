package com.academic.inventory.service;
import com.academic.inventory.entities.Category;
import com.academic.inventory.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service

public class CategoryService {
    private final CategoryRepository  categoryRepository;

    public  CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();

    }
    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Category update(Long id, Category data) {
        Category category = findById(id);
        category.setName(data.getName());
        category.setDescription(data.getDescription());
        return categoryRepository.save(category);
    }

    public void deleteById(Long id) {
        findById(id);
        categoryRepository.deleteById(id);
    }
}



