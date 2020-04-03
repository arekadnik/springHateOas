package com.example.demo.service;


import com.example.demo.model.Car;

import java.util.Optional;

public interface CarService {
    java.util.List<Car> getAllCars();

    Optional<Car> getCarById(long id);

    java.util.List<Car> getCarsByColor(String color);
}
