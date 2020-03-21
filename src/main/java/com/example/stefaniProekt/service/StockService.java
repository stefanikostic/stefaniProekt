package com.example.stefaniProekt.service;

import com.example.stefaniProekt.model.Product;
import com.example.stefaniProekt.model.Stock;
import com.example.stefaniProekt.model.Store;
import java.util.List;

public interface StockService {
    Stock createStock(Product product, Store store, int quantity, int price);
    List<Stock> getAllStocks();
    Stock updateStock(int stockId, Product product, Store store, int quantity, int price);
    void deleteStock(int stockId);
    Stock findByStockId(int stockId);
    List<Stock> getAllStocksByStore(int storeId);
    List<Stock> getAllStocksByProduct(String productCode);
    List<Stock> searchStocks(String term);
    List<Stock> searchStocksByStore(String store);
}
