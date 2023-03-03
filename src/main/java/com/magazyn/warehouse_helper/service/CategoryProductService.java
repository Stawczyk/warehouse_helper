package com.magazyn.warehouse_helper.service;

import com.magazyn.warehouse_helper.model.CategoryProduct;

import java.util.List;

public interface CategoryProductService {

   CategoryProduct saveCategoryProduct (CategoryProduct categoryProduct);

   List<CategoryProduct> getAllCategoryProduct();

   CategoryProduct getCategoryProductById(Long id);

   CategoryProduct updateCategoryProductById(CategoryProduct categoryProduct, Long id );

   void deleteCategoryProduct(Long id );

}
