package com.joseloya.torrexfitness.service;

import com.joseloya.torrexfitness.model.Product;
import com.joseloya.torrexfitness.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {

        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
//        Optional<Product> optional = productRepository.findById(id);
//        Product product = null;
//        if (optional.isPresent()) {
//            product = optional.get();
//        } else {
//            throw new RuntimeException(" Product not found for id :: " + id);
//        }
//        return product;
    }

    @Override
    public void deleteProductById(Long id) {
        this.productRepository.deleteById(id);
    }
}
