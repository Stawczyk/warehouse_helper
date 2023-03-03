package com.magazyn.warehouse_helper.repository;

import com.magazyn.warehouse_helper.model.CategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryProductRepository extends JpaRepository <CategoryProduct,Long>{
}
