package com.magazyn.warehouse_helper.repository;

import com.magazyn.warehouse_helper.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
