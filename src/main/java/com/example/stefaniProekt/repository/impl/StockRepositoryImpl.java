package com.example.stefaniProekt.repository.impl;

import com.example.stefaniProekt.model.Stock;
import com.example.stefaniProekt.repository.StockRepository;
import com.example.stefaniProekt.repository.jpa.JpaStockRepository;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StockRepositoryImpl implements StockRepository {
    private final JpaStockRepository repository;

    public StockRepositoryImpl(JpaStockRepository repository) {
        this.repository = repository;
    }

    @Override
    public Stock save(Stock stock) {
        return this.repository.save(stock);
    }

    @Override
    public List<Stock> getAllStocks() {
        return this.repository.findAll();
    }

    @Override
    public Optional<Stock> findById(int stockId) {
        return this.repository.findById(stockId);
    }

    @Override
    public void deleteById(int stockId) {
        this.repository.deleteById(stockId);
    }

    @Override
    public List<Stock> getAllStocksByStore(int storeId) {
        return this.repository.findAll().stream()
                .filter(s -> s.getStore().getStoreId()==storeId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Stock> getAllStocksByProduct(String productCode) {
        List<Stock> sorted = this.repository.findAll()
                .stream()
                .filter(p -> p.getProduct().getCode().equals(productCode))
                .sorted(Comparator.comparingInt(Stock::getPrice))
                .collect(Collectors.toList());
        return sorted;
    }

/*    @Override
    public List<Product> getAllProductsByStore(int storeId) {
        List<Stock> stocksStore = this.getAllStocksByStore(storeId);
        return stoc
    }*/
}
