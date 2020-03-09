package com.example.stefaniProekt.controller.rest;

import com.example.stefaniProekt.model.Category;
import com.example.stefaniProekt.model.Product;
import com.example.stefaniProekt.model.exceptions.InvalidCategoryIdException;
import com.example.stefaniProekt.model.exceptions.InvalidProductCodeException;
import com.example.stefaniProekt.service.CategoryService;
import com.example.stefaniProekt.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/products", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class ProductApi {
    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductApi(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(params = "term")
    public List<Product> searchProducts(@RequestParam String term) {
        return productService.searchProducts(term);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Product createProduct(@RequestParam("code") String code,
                                 @RequestParam("name") String name,
                                 @RequestParam("logoProduct") String logoProduct,
                                 @RequestParam("country") String country,
                                 @RequestParam("price") int price,
                                 @RequestParam("category") int categoryid,
                                 HttpServletResponse response,
                                 UriComponentsBuilder builder){
        Category category = categoryService.findById(categoryid).orElseThrow(InvalidCategoryIdException::new);
        Product product1 = this.productService.createProduct(code, name, logoProduct, country, price, category);
        response.setHeader("Location", builder.path("/api/products/{product.getCode()}").buildAndExpand(product1.getCode()).toUriString());
        return product1;
    }

    @GetMapping("/{code}")
    public Product getProduct(@PathVariable String code) {
        return this.productService.findByCode(code).orElseThrow(InvalidProductCodeException::new);
    }

    @PatchMapping("/{code}")
    public Product updateProduct(@PathVariable String code,
                                 @RequestParam("name") String name,
                                 @RequestParam("logoProduct") String logoProduct,
                                 @RequestParam("country") String country,
                                 @RequestParam("price") int price,
                                 @RequestParam("category") int categoryid){
        Category category = categoryService.findById(categoryid).orElseThrow(InvalidCategoryIdException::new);
        return productService.updateProduct(code, name, logoProduct, country, price, category);
    }

    @DeleteMapping("/{code}")
    public void deleteProduct(@PathVariable String code) {
        productService.deleteProduct(code);
    }

}
