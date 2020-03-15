package com.example.stefaniProekt.service;

import com.example.stefaniProekt.model.Promotion;
import java.util.List;

public interface PromotionService {
    Promotion createPromotion(String promotionUrl);
    List<Promotion> getAllPromotions();
    Promotion updatePromotion(int promotionId, String promotionUrl);
    void deletePromotion(int promotionId);
    Promotion findById(int promotionId);
    void deleteAllPromotions();
}
