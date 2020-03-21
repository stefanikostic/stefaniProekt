package com.example.stefaniProekt.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Data
public class Store {
    @Transient
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static int storesCounter = 1;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int storeId;
    private String name;
    private String address;
    private String logoMarket;
 /*   @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="stock", joinColumns = { @JoinColumn(name="store_id", referencedColumnName = "id")},
    inverseJoinColumns = { @JoinColumn(name="product_code", referencedColumnName = "code")})*//*
    private List<Product> products;*/
   /* @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private Set<Stock> stock = new HashSet<>();*/
    //@OneToMany
    // private List<LocationMarket> locations;
    public static synchronized Store createOneTimeStore(String name, String address, String logoMarket) {
        Store store = new Store();
        store.setStoreId(storesCounter);
        storesCounter++;
        store.setName(name);
        store.setAddress(address);
        store.setLogoMarket(logoMarket);
        return store;
    }
}
