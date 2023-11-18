package com.project.dev.carorderingproject.service;

import com.project.dev.carorderingproject.entity.Car;
import com.project.dev.carorderingproject.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public List<Car> getAvailableCars() {
        return carRepository.findByAvailableTrue();
    }

    public Optional<Car> getCarById(Long id) {
        return Optional.ofNullable(carRepository.findById(id).orElse(null));
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}

