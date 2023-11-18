package com.project.dev.carorderingproject.repository;

import com.project.dev.carorderingproject.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByAvailableTrue();

    List<Car> findAll();

    Optional<Car> findById(Long id);

    Car save(Car car);

    void deleteById(Long id);
}

