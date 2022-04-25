package com.joseloya.torrexfitness.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void existsById_should_return_true_given_existing_product_id() {
        Boolean productExists = productRepository.existsById(1L);
        Assertions.assertThat( productExists == true);
    }
}