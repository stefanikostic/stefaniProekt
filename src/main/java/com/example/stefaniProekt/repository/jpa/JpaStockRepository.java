package com.example.stefaniProekt.repository.jpa;

import com.example.stefaniProekt.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaStockRepository extends JpaRepository<Stock, Integer> {

}
