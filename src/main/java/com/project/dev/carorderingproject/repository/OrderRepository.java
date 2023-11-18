package com.project.dev.carorderingproject.repository;

import com.project.dev.carorderingproject.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findById(Long id);

    Order save(Order order);

    void deleteById(Long id);
    // Custom queries or methods can be added here if needed
}

