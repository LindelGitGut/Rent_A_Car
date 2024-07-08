package de.lindele.carapp.rental.controller;

import de.lindele.carapp.rental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController("/rental")
public class RentalController {



    @Autowired
    RentalService rentalService;




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
