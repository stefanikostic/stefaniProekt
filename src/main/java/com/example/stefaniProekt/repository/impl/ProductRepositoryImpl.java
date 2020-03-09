package com.example.stefaniProekt.repository.impl;
import com.example.stefaniProekt.model.Product;
import com.example.stefaniProekt.repository.ProductRepository;
import com.example.stefaniProekt.repository.jpa.JpaProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private final JpaProductRepository repository;

    public ProductRepositoryImpl(JpaProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product save(Product product) {
        return this.repository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        /*org.springframework.data.domain.Page<Product> result = this.repository.findAll(PageRequest.of(page, size));
        return new Page<>(page,
                result.getTotalPages(),
                size,
                result.getContent());*/
        return this.repository.findAll();
    }

    @Override
    public List<Product> searchProducts(String term) {
        return this.repository.searchProducts(term);
    }

    @Override
    public Optional<Product> findById(String productCode) {
        return this.repository.findById(productCode);
    }

    @Override
    public void deleteById(String productCode) {
        this.repository.deleteById(productCode);
    }
}
