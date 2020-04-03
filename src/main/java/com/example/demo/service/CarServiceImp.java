package com.example.demo.service;

import com.example.demo.model.Car;
import com.example.demo.model.Color;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImp implements CarService {
    @Override
    public java.util.List<Car> getAllCars() {
        return createListOfCars();

    }


    @Override
    public Optional<Car> getCarById(long id) {
        return createListOfCars().stream()
                .filter(car -> car.getCarID() == id)
                .findFirst();
    }

    @Override
    public List<Car> getCarsByColor(String color) {
        return createListOfCars()
                .stream()
                .filter(car -> color.equalsIgnoreCase(car.getColor().name()))
                .collect(Collectors.toList());
    }

    private List<Car> createListOfCars() {
        List<Car> carsList = new ArrayList<>();
        carsList.add(new Car(1L, "Mercedes", "GLC 300", Color.NAVY_BLUE));
        carsList.add(new Car(2L, "Maserati", "Quatroporte", Color.MARINE));
        carsList.add(new Car(3L, "Alfa Romeo", "Giulia", Color.RED));
        carsList.add(new Car(4L, "Mercedes", "EQC", Color.BLACK));
        carsList.add(new Car(5L, "Ferrari", "Califormnia", Color.BLUE));
        carsList.add(new Car(6L, "Bugatti", "La Voiuture Noure", Color.WHITE));
        return carsList;
    }
}
