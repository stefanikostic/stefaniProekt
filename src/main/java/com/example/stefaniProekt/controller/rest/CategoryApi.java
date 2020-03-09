package com.example.stefaniProekt.controller.rest;

import com.example.stefaniProekt.model.Category;
import com.example.stefaniProekt.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "api/categories", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class CategoryApi {

    private final CategoryService categoryService;

    public CategoryApi(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category createCategory(@RequestBody Category category) {
        this.categoryService.createCategory(category.getCategoryid(), category.getName(), category.getParent());
        return category;
    }

}
