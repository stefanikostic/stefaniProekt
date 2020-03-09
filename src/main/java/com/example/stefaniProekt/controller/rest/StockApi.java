package com.example.stefaniProekt.controller.rest;


import com.example.stefaniProekt.model.Stock;
import com.example.stefaniProekt.service.StockService;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/stocks", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class StockApi {
    private StockService stockService;

    public StockApi(StockService stockService){
        this.stockService = stockService;
    }

    @GetMapping
    public List<Stock> getAllStocks() {
        return this.stockService.getAllStocks();
    }

    @GetMapping("/{stockId}")
    public Stock getStock(@PathVariable int stockId) {
        return this.stockService.findByStockId(stockId);
    }

    @GetMapping(params = "code")
    public List<Stock> getAllStocksByProduct(@RequestParam String code){
        return this.stockService.getAllStocksByProduct(code);
    }

    @GetMapping(params = "store")
    public List<Stock> getAllStocksByStore(@RequestParam int store){
        return this.stockService.getAllStocksByStore(store);
    }
}
