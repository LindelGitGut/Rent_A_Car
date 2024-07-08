package de.lindele.carapp.customer.controller;


import de.lindele.carapp.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;



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
