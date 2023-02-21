package com.magazyn.warehouse_helper.service;


import com.magazyn.warehouse_helper.model.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    List<Product> getAllProduct();

     Product getProductById (Long id);

     Product updateProductById( Product product,long id );

     void deleteProduct (long id);
}
