package com.example.stefaniProekt.service.impl;

import com.example.stefaniProekt.model.Category;
import com.example.stefaniProekt.model.exceptions.InvalidCategoryIdException;
import com.example.stefaniProekt.repository.jpa.CategoryRepository;
import com.example.stefaniProekt.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(int categoryId, String name, Category parent) {
        Category category = new Category(categoryId, name, parent);
        return this.categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(int categoryId, String name, Category parent) {
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(InvalidCategoryIdException::new);
        category.setName(name);
        category.setParent(parent);
        return this.categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(int categoryId) {
        this.categoryRepository.deleteById(categoryId);
    }

    @Override
    public Optional<Category> findById(int categoryId) {
        return this.categoryRepository.findById(categoryId);
    }
}
