package com.example.stefaniProekt.repository;

import com.example.stefaniProekt.model.Store;

import java.util.List;
import java.util.Optional;

public interface StoreRepository {
    Store save(Store store);
    List<Store> getAllStores();
    Optional<Store> findById(int storeId);
    Store findByName(String name);
    void deleteById(int storeId);
}
