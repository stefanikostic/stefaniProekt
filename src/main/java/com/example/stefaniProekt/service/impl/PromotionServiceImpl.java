package com.example.stefaniProekt.service.impl;

import com.example.stefaniProekt.model.Promotion;
import com.example.stefaniProekt.model.exceptions.InvalidPromotionException;
import com.example.stefaniProekt.repository.jpa.PromotionRepository;
import com.example.stefaniProekt.service.PromotionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService {
    private final PromotionRepository promotionRepository;

    public PromotionServiceImpl(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @Override
    public Promotion createPromotion(String promotionUrl) {
        Promotion promotion = Promotion.createPromotion(promotionUrl);
        return this.promotionRepository.save(promotion);
    }

    @Override
    public List<Promotion> getAllPromotions() {
        return this.promotionRepository.findAll();
    }

    @Override
    public Promotion updatePromotion(int promotionId, String promotionUrl) {
        Promotion promotion = this.promotionRepository.findById(promotionId).orElseThrow(InvalidPromotionException::new);
        promotion.setPromotionUrl(promotionUrl);
        return this.promotionRepository.save(promotion);
    }

    @Override
    public void deletePromotion(int promotionId) {
        this.promotionRepository.deleteById(promotionId);
    }

    @Override
    public Promotion findById(int promotionId) {
        return this.promotionRepository.findById(promotionId).orElseThrow(InvalidPromotionException::new);
    }

    @Override
    public void deleteAllPromotions() {
        this.promotionRepository.deleteAll();
    }
}
