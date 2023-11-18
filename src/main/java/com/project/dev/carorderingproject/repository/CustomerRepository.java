package com.project.dev.carorderingproject.repository;

import com.project.dev.carorderingproject.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Find a customer by email
    Customer findByEmail(String email);

    // Check if a customer with a given email exists
    boolean existsByEmail(String email);
}
