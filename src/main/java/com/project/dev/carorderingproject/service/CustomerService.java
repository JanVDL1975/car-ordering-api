package com.project.dev.carorderingproject.service;

import com.project.dev.carorderingproject.entity.Customer;
import com.project.dev.carorderingproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Get all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Get customer by ID
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    // Save a new customer or update an existing one
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Delete a customer by ID
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    // Find a customer by email
    public Optional<Customer> findCustomerByEmail(String email) {
        return ofNullable(customerRepository.findByEmail(email));
    }
}

