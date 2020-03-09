package com.example.stefaniProekt.controller;

import com.example.stefaniProekt.model.Category;
import com.example.stefaniProekt.model.Product;
import com.example.stefaniProekt.model.Stock;
import com.example.stefaniProekt.model.Store;
import com.example.stefaniProekt.repository.jpa.CategoryRepository;
import com.example.stefaniProekt.repository.jpa.JpaProductRepository;
import com.example.stefaniProekt.repository.jpa.JpaStockRepository;
import com.example.stefaniProekt.repository.jpa.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/demo")
public class MainController {
    @Autowired
    private JpaProductRepository productRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private JpaStockRepository stockRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    //TO DO: add interface (react) for a form and see if its successfull
    @PostMapping(path="/add")
    public @ResponseBody String addNewProduct (@RequestParam String code, @RequestParam String name, @RequestParam String logoProduct,
                                               @RequestParam String country,
                                               @RequestParam int price){
        Product p = new Product();
        p.setName(name);
        p.setCountry(country);
        p.setLogoProduct(logoProduct);
        p.setPrice(price);
        p.setCode(code);
        productRepository.save(p);
        return "Saved";
    }

    @GetMapping(path="/stock")
    public @ResponseBody Iterable<Stock> getStock() { return stockRepository.findAll(); }

    @GetMapping(path="/allStores")
    public @ResponseBody Iterable<Store> getAllStores(){
        return storeRepository.findAll();
    }

    @GetMapping(path="/allCategories")
    public @ResponseBody Iterable<Category> getAllCategories(){
        System.out.println("category");
        return categoryRepository.findAll();
    }

    @GetMapping(path="/allProducts")
    public @ResponseBody Iterable<Product> getAllProducts(){
        return productRepository.findAll();
    }
}
