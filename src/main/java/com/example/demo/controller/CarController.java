package com.example.demo.controller;

import com.example.demo.model.Car;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


@RestController
@RequestMapping(value = "/cars", produces = {org.springframework.http.MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin
public class CarController {

    CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<CollectionModel<Car>> getCars() {
        List<Car> allCars = carService.getAllCars();
        allCars.forEach(car -> car.add(linkTo(CarController.class).slash(car.getCarID()).withSelfRel()));
        Link link = linkTo(CarController.class).withSelfRel();
        CollectionModel<Car> collectionModel = new CollectionModel(allCars, link);
        return new ResponseEntity(collectionModel, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Car>> getCarByID(@PathVariable long id) {
        org.springframework.hateoas.Link link = linkTo(CarController.class).slash(id).withSelfRel();
        Optional<Car> carById = carService.getCarById(id);
        EntityModel<Car> entityModel = new EntityModel(carById, link);
        return new ResponseEntity<>(entityModel, HttpStatus.OK);
    }

    @GetMapping("/color/{color}")
    public ResponseEntity<CollectionModel<Car>> getCarByColor(@PathVariable String color) {
        List<Car> carList = carService.getCarsByColor(color);
        carList.forEach(car -> car.add(linkTo(CarController.class).slash(car.getCarID()).withSelfRel()));
        carList.forEach(car -> car.add(linkTo(CarController.class).withRel("allColors")));
        Link link = linkTo(CarController.class).withSelfRel();
        CollectionModel<Car> collectionModel = new CollectionModel(carList, link);
        return new ResponseEntity<>(collectionModel, HttpStatus.OK);
    }

}
