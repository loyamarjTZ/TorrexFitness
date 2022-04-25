package com.joseloya.torrexfitness.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CartItemRepositoryTest {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Test
    void existsById_should_return_true_given_existing_cartItem_id() {
        Boolean cartItemExists = cartItemRepository.existsById(1L);
        Assertions.assertThat( cartItemExists == true);
    }
}