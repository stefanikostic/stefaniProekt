package com.example.stefaniProekt.service;

import com.example.stefaniProekt.model.Store;
import java.util.List;

public interface StoreService {
    Store createStore(String name, String address, String logoMarket);
    List<Store> getAllStores();
    Store updateStore(int storeId, String name, String address, String logoMarket);
    void deleteStore(int storeId);
    Store findByStoreId(int storeId);
}
