package com.example.stefaniProekt.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Data
public class Stock {
    @Transient
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static int stocksCounter = 1;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Store store;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stockId;

    private int quantity;
    private int price;

    public static synchronized Stock createOneTimeStock(Product product, Store store, int quantity, int price){
        Stock stock = new Stock();
        stock.stockId = stocksCounter;
        stocksCounter++;
        stock.product = product;
        stock.store = store;
        stock.quantity = quantity;
        stock.price = price;
        return stock;
    }


}
