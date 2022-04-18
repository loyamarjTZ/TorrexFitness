package com.joseloya.torrexfitness.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.joseloya.torrexfitness.model.Customer;
import com.joseloya.torrexfitness.repository.CustomerRepository;
import com.joseloya.torrexfitness.security.Role;
import com.joseloya.torrexfitness.security.User;
import com.joseloya.torrexfitness.security.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List < Customer > getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void saveCustomer(Customer customer) {
        this.customerRepository.save(customer);
    }

    public Customer save(UserRegistrationDto registration){
        Customer customer = new Customer();
        customer.setFirstName(registration.getFirstName());
        customer.setLastName(registration.getLastName());
        customer.setEmail(registration.getEmail());
//        customer.setPassword(passwordEncoder.encode(registration.getPassword()));

//        if(customer.getFirstName().contains("superadmin")){
//            customer.setRoles(Arrays.asList(
//                    new Role("ROLE_SUPERADMIN"),
//                    new Role("ROLE_ADMIN"),
//                    new Role("ROLE_USER")
//            ));
//        } else if(customer.getFirstName().contains("admin")) {
//            customer.setRoles(Arrays.asList(
//                    new Role("ROLE_ADMIN"),
//                    new Role("ROLE_USER")
//            ));
//        } else {
//            customer.setRoles(Arrays.asList(
//                    new Role("ROLE_USER")
//            ));
//        }

        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(long id) {
        Optional <Customer> optional = customerRepository.findById(id);
        Customer customer = null;
        if (optional.isPresent()) {
            customer = optional.get();
        } else {
            throw new RuntimeException("Customer not found for id: " + id);
        }
        return customer;
    }

    @Override
    public void deleteCustomerById(long id) {
        this.customerRepository.deleteById(id);
    }
}
