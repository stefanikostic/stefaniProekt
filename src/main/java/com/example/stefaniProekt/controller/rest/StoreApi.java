package com.example.stefaniProekt.controller.rest;

import com.example.stefaniProekt.model.Store;
import com.example.stefaniProekt.service.StoreService;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/stores", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class StoreApi {
    private StoreService storeService;
    public StoreApi(StoreService storeService){
        this.storeService = storeService;
    }

    @GetMapping
    public List<Store> getAllStores() {
        return this.storeService.getAllStores();
    }
}
