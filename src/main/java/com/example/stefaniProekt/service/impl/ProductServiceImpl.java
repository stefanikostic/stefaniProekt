package com.example.stefaniProekt.service.impl;
import com.example.stefaniProekt.model.Category;
import com.example.stefaniProekt.model.Product;
import com.example.stefaniProekt.model.exceptions.InvalidProductCodeException;
import com.example.stefaniProekt.repository.ProductRepository;
import com.example.stefaniProekt.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(String code, String name, String logoProduct, String country, int price, Category category) {
        Product product = new Product(code, name, logoProduct, country, price, category);
        return this.productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.getAllProducts();
    }

    @Override
    public List<Product> searchProducts(String term) {
        return this.productRepository.searchProducts(term);
    }

    @Override
    public Product updateProduct(String code, String name, String logoProduct, String country, int price, Category category) {
        Product product = this.productRepository.findById(code).orElseThrow(InvalidProductCodeException::new);
        product.setName(name);
        product.setLogoProduct(logoProduct);
        product.setCountry(country);
        product.setPrice(price);
        product.setCategory(category);
        return this.productRepository.save(product);
    }

    @Override
    public void deleteProduct(String code) {
        this.productRepository.deleteById(code);
    }

    @Override
    public Optional<Product> findByCode(String code) {
        return this.productRepository.findById(code);
    }
}
