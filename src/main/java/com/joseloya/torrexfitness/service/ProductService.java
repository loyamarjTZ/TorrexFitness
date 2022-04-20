package com.joseloya.torrexfitness.service;

import com.joseloya.torrexfitness.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    void saveProduct(Product product);

    Product getProductById(Long id);

    void deleteProductById(Long id);
}
