package com.example.stefaniProekt.repository.impl;

import com.example.stefaniProekt.model.Store;
import com.example.stefaniProekt.repository.StoreRepository;
import com.example.stefaniProekt.repository.jpa.JpaStoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreRepositoryImpl implements StoreRepository {
    private final JpaStoreRepository jpaStoreRepository;

    public StoreRepositoryImpl(JpaStoreRepository jpaStoreRepository) {
        this.jpaStoreRepository = jpaStoreRepository;
    }

    @Override
    public Store save(Store store) {
        return this.jpaStoreRepository.save(store);
    }

    @Override
    public List<Store> getAllStores() {
        return this.jpaStoreRepository.findAll();
    }

    @Override
    public Optional<Store> findById(int storeId) {
        return this.jpaStoreRepository.findById(storeId);
    }

    @Override
    public Store findByName(String name) {
        List<Store> stores = this.jpaStoreRepository.findAll();
        for(Store s : stores) {
            if(s.getName().toLowerCase().equals(name))
                return s;
        }
        return null;
    }

    @Override
    public void deleteById(int storeId) {
        this.jpaStoreRepository.deleteById(storeId);
    }
}
