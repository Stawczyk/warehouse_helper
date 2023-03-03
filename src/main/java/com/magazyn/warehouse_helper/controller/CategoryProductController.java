package com.magazyn.warehouse_helper.controller;

import com.magazyn.warehouse_helper.model.CategoryProduct;
import com.magazyn.warehouse_helper.service.CategoryProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/CategoryProduct")
public class CategoryProductController {
    private CategoryProductService categoryProductService;

    public CategoryProductController(CategoryProductService categoryProductService) {
        this.categoryProductService = categoryProductService;
    }

    // REST API saveCategoryProduct
   @PostMapping
   public ResponseEntity<CategoryProduct> saveCategoryProduct ( @RequestBody CategoryProduct categoryProduct){
        return new ResponseEntity<CategoryProduct>(categoryProductService.saveCategoryProduct(categoryProduct), HttpStatus.CREATED);
   }

   // REST API getAllCategoryProduct

    @GetMapping
    public List<CategoryProduct> getAllCategoryProduct (){
        return categoryProductService.getAllCategoryProduct();
    }

    // REST API getCategoryProductById
    @GetMapping("{id}")
    public ResponseEntity<CategoryProduct> getCategoryProductById (@PathVariable("id") Long id){
        return new ResponseEntity<CategoryProduct>(categoryProductService.getCategoryProductById(id),HttpStatus.OK);
    }

    // REST API updateCategoryProductById

    @PutMapping("{id}")
    public ResponseEntity<CategoryProduct> updateCategoryProductById(@RequestBody CategoryProduct categoryProduct, @PathVariable("id") Long id ){
        return new ResponseEntity<CategoryProduct>(categoryProductService.updateCategoryProductById(categoryProduct,id),HttpStatus.OK);
    }
    // RESR API deleteCategoryProduct

    @DeleteMapping ("{id}")
    public ResponseEntity<String>deleteCategoryProduct (@PathVariable ("id") Long id ){
        categoryProductService.deleteCategoryProduct(id);
       return new ResponseEntity<>("CategoryProduct is delete",HttpStatus.OK);
    }
}
