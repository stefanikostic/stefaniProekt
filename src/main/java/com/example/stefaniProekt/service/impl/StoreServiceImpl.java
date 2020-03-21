package com.example.stefaniProekt.service.impl;

import com.example.stefaniProekt.model.Store;
import com.example.stefaniProekt.model.exceptions.InvalidStoreException;
import com.example.stefaniProekt.repository.jpa.JpaStoreRepository;
import com.example.stefaniProekt.service.StoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    private final JpaStoreRepository storeRepository;

    public StoreServiceImpl(JpaStoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public Store createStore(String name, String address, String logoMarket) {
        Store store = Store.createOneTimeStore(name, address, logoMarket);
        return this.storeRepository.save(store);
    }

    @Override
    public List<Store> getAllStores() {
        return this.storeRepository.findAll();
    }

    @Override
    public Store updateStore(int storeId, String name, String address, String logoMarket) {
        Store store = this.storeRepository.findById(storeId).orElseThrow(InvalidStoreException::new);
        store.setName(name);
        store.setAddress(address);
        store.setLogoMarket(logoMarket);
        return this.storeRepository.save(store);
    }

    @Override
    public void deleteStore(int storeId) {
        Store store = this.storeRepository.findById(storeId).orElseThrow(InvalidStoreException::new);
        this.storeRepository.delete(store);
    }

    @Override
    public Store findByStoreId(int storeId) {
        return this.storeRepository.findById(storeId).orElseThrow(InvalidStoreException::new);
    }
}
