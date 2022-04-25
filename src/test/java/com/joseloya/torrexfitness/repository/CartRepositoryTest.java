package com.joseloya.torrexfitness.repository;

import com.joseloya.torrexfitness.model.Cart;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CartRepositoryTest {

    @Autowired
    private CartRepository cartRepository;

    @Test
    void existsById_should_return_true_given_existing_cart_id() {
        Boolean cartExists = cartRepository.existsById(1L);
        Assertions.assertThat( cartExists == true);
    }
}