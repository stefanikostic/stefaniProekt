package com.example.stefaniProekt.repository;

import com.example.stefaniProekt.model.Stock;

import java.util.List;
import java.util.Optional;

public interface StockRepository {
    Stock save(Stock stock);
    List<Stock> getAllStocks();
    Optional<Stock> findById(int stockId);
    void deleteById(int stockId);
    List<Stock> getAllStocksByStore(int storeId);
    List<Stock> getAllStocksByProduct(String productCode);
//    List<Product> getAllProductsByStore(int storeId);
}
