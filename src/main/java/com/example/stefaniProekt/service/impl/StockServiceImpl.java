package com.example.stefaniProekt.service.impl;

import com.example.stefaniProekt.model.Product;
import com.example.stefaniProekt.model.Stock;
import com.example.stefaniProekt.model.Store;
import com.example.stefaniProekt.model.exceptions.InvalidStockException;
import com.example.stefaniProekt.repository.StockRepository;
import com.example.stefaniProekt.service.StockService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {
    private final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Stock createStock(Product product, Store store, int quantity, int price) {
        Stock stock = Stock.createOneTimeStock(product, store, quantity, price);
        return this.stockRepository.save(stock);
    }

    @Override
    public List<Stock> getAllStocks() {
        return this.stockRepository.getAllStocks();
    }

    @Override
    public Stock updateStock(int stockId, Product product, Store store, int quantity, int price) {
        Stock stock = this.stockRepository.findById(stockId).orElseThrow(InvalidStockException::new);
        stock.setProduct(product);
        stock.setStore(store);
        stock.setQuantity(quantity);
        stock.setPrice(price);
        return this.stockRepository.save(stock);
    }

    @Override
    public void deleteStock(int stockId) {
        this.stockRepository.deleteById(stockId);
    }

    @Override
    public Stock findByStockId(int stockId) {
        return this.stockRepository.findById(stockId).orElseThrow(InvalidStockException::new);
    }

    @Override
    public List<Stock> getAllStocksByStore(int storeId) {
        return this.stockRepository.getAllStocksByStore(storeId);
    }

    @Override
    public List<Stock> getAllStocksByProduct(String productCode) {
        return this.stockRepository.getAllStocksByProduct(productCode);
    }
}
