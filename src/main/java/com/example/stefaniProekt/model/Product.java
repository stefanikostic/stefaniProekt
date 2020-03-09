package com.example.stefaniProekt.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Data
public class Product {
    @Id
    @Column(name="code")
    private String code;
    @NotNull(message = "Product name is required.")
    private String name;
    private String logoProduct;
    private String country;
    private int price;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
/*    @JsonIgnore
    @ManyToMany(mappedBy = "products")
    @NotFound(action = NotFoundAction.IGNORE)
    List<Store> stores;*/


    //private int sale;
    /*@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Stock> stock = new HashSet<>();*/
}
