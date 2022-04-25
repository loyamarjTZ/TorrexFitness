package com.joseloya.torrexfitness.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void existsById_should_return_true_given_existing_customer_id() {
        Boolean customerExists = customerRepository.existsById(1L);
        Assertions.assertThat( customerExists == true);
    }
}