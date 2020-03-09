package com.example.stefaniProekt.repository;

import com.example.stefaniProekt.model.Product;
import com.example.stefaniProekt.model.vm.Page;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);
    List<Product> getAllProducts();
    List<Product> searchProducts(String term);
    Optional<Product> findById(String productCode);
    void deleteById(String productCode);
}
