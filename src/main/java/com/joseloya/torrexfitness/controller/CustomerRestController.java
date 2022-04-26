package com.joseloya.torrexfitness.controller;

import com.joseloya.torrexfitness.model.Customer;
import com.joseloya.torrexfitness.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRestController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }
}
