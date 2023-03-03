package com.magazyn.warehouse_helper.repository;

import com.magazyn.warehouse_helper.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("SELECT p FROM Product p WHERE p.nameProduct=?1")
    Product getProductByNameProduct (String nameProduct);


}
