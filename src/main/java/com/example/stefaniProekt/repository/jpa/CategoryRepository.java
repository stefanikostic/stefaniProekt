package com.example.stefaniProekt.repository.jpa;

import com.example.stefaniProekt.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
