package de.lindele.carapp.car.controller;


import de.lindele.carapp.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/car")
public class CarController {

    @Autowired
    CarService carService;




    //TODO Implement CRUD-Endpoints
    //CREATE

    @PostMapping


    //READ
    @GetMapping

    //UPDATE
    @PutMapping


    //DELETE
    @DeleteMapping

}
