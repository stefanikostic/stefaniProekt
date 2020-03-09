package com.example.stefaniProekt.service;

import com.example.stefaniProekt.model.Category;
import java.util.List;

import java.util.Optional;

public interface CategoryService {
    Category createCategory(int categoryId, String name, Category parent);
    List<Category> getAllCategories();
    Category updateCategory(int categoryId, String name, Category parent);
    void deleteCategory(int categoryId);
    Optional<Category> findById(int categoryId);
}
