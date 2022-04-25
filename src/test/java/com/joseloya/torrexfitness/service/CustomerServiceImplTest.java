package com.joseloya.torrexfitness.service;

import com.joseloya.torrexfitness.model.Customer;
import com.joseloya.torrexfitness.service.CustomerService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerServiceImplTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void should_return_true_when_at_least_one_customer_exists_in_DB(){
        List<Customer> customerList = customerService.getAllCustomers();
        Customer customer = customerList.get(0);
        if(customer != null){
            Customer customer2 = customerService.getCustomerById(1L);
            Assertions.assertThat(customer2.getId()).isEqualTo(1L);
        }
    }
}
