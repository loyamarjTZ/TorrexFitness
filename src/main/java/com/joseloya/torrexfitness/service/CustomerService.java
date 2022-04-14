package com.joseloya.torrexfitness.service;

import com.joseloya.torrexfitness.model.Customer;

import java.util.List;

public interface CustomerService {
    List <Customer> getAllCustomers();
    void saveCustomer(Customer customer);
    Customer getCustomerById(long id);
    void deleteCustomerById(long id);
}