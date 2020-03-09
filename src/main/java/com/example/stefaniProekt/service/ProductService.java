package com.example.stefaniProekt.service;

import com.example.stefaniProekt.model.Category;
import com.example.stefaniProekt.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product createProduct(String code, String name, String logoProduct, String country, int price, Category category);
    List<Product> getAllProducts();
    List<Product> searchProducts(String term);
    Product updateProduct(String code, String name, String logoProduct, String country, int price, Category category);
    void deleteProduct(String code);
    Optional<Product> findByCode(String code);
}
