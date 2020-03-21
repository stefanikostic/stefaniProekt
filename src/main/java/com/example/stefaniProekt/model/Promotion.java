package com.example.stefaniProekt.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Data
@Getter
@Setter
public class Promotion {
    @Transient
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static int promotionCounter = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int promotionId;
    private String promotionUrl;
    @ManyToOne(targetEntity = Store.class)
    @JoinColumn(name="store_id")
    private Store store;
    public static synchronized Promotion createPromotion (String promotionUrl) {
        Promotion promotion = new Promotion();
        promotion.setPromotionId(promotionCounter);
        promotionCounter++;
        promotion.setPromotionUrl(promotionUrl);
        return promotion;
    }
}

