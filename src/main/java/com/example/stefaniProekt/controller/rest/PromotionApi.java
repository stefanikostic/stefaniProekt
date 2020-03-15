package com.example.stefaniProekt.controller.rest;

import com.example.stefaniProekt.model.Promotion;
import com.example.stefaniProekt.service.PromotionService;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/promotions", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class PromotionApi {
    private final PromotionService promotionService;

    public PromotionApi(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @GetMapping
    public List<Promotion> getAllPromotions() {
        return this.promotionService.getAllPromotions();
    }

    @GetMapping("/{id}")
    public Promotion getPromotion(@PathVariable int id){
        return this.promotionService.findById(id);
    }


    @DeleteMapping("/{id}")
    public void deletePromotion(@PathVariable int id){
        this.promotionService.deletePromotion(id);
    }
}
