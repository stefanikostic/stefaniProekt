package com.example.stefaniProekt.repository.jpa;

import com.example.stefaniProekt.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaStockRepository extends JpaRepository<Stock, Integer> {
    @Query("SELECT s FROM Stock s JOIN Product p ON s.product.code=p.code where p.name like :term%")
    List<Stock> searchStocks(@Param("term") String term);

    @Query("SELECT s FROM Stock s JOIN Store st ON s.store.id=st.id where st.name like :store%")
    List<Stock> searchStocksByStore(@Param("store") String store);

}
