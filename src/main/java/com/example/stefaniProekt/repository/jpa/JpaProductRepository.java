package com.example.stefaniProekt.repository.jpa;

import com.example.stefaniProekt.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface JpaProductRepository extends JpaRepository<Product, String> {
    @Query("SELECT p FROM Product p where p.name like :term%")
    List<Product> searchProducts(@Param("term") String term);
}
