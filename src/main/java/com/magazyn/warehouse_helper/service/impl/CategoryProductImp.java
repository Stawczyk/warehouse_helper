package com.magazyn.warehouse_helper.service.impl;

import com.magazyn.warehouse_helper.Exception.ResourceNotFoundException;
import com.magazyn.warehouse_helper.model.CategoryProduct;
import com.magazyn.warehouse_helper.repository.CategoryProductRepository;
import com.magazyn.warehouse_helper.service.CategoryProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryProductImp implements CategoryProductService {

    private CategoryProductRepository categoryProductRepository;

    public CategoryProductImp(CategoryProductRepository categoryProductRepository) {
        this.categoryProductRepository = categoryProductRepository;
    }
    // zapis jednego CategoryProduct
    @Override
    public CategoryProduct saveCategoryProduct(CategoryProduct categoryProduct) {
        return categoryProductRepository.save(categoryProduct);
    }
    // lista wszystkich CategoryProduct
    @Override
    public List<CategoryProduct> getAllCategoryProduct() {
        return categoryProductRepository.findAll();
    }
    // CategoryProduct po id
    @Override
    public CategoryProduct getCategoryProductById(Long id) {
        return categoryProductRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("CategoryProduct","id",id));
    }
    // aktualizacja CategoryProduct
    @Override
    public CategoryProduct updateCategoryProductById(CategoryProduct categoryProduct, Long id) {
      CategoryProduct existingCategoryProduct = categoryProductRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("CategoryProduct","id",id));
        existingCategoryProduct.setName(categoryProduct.getName());
        existingCategoryProduct.setVat(categoryProduct.getVat());

        categoryProductRepository.save(existingCategoryProduct);

        return existingCategoryProduct;
    }
    // usuwanie CategoryProduct
    @Override
    public void deleteCategoryProduct(Long id) {
        categoryProductRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("CategoryProduct","id",id));
        categoryProductRepository.deleteById(id);
    }



}
