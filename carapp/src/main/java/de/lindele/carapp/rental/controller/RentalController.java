package de.lindele.carapp.rental.controller;

import de.lindele.carapp.rental.service.RentalService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController("/rental")
@Api(value = "Rental Management System")
public class RentalController {



    @Autowired
    RentalService rentalService;




    //TODO Implement CRUD-Endpoints
    //CREATE

    @PostMapping
    <RentalWebModel> ResponseEntity<RentalWebModel> createRental(@RequestBody RentalWebModel rentalWebModel) {
        return ResponseEntity.ok(rentalService.createRental(rentalWebModel));
    }


    //READ
    @GetMapping
    <RentalWebModel> ResponseEntity<RentalWebModel> getRental(@PathVariable Long id) {
        return ResponseEntity.ok(rentalService.getRental(id));
    }

    //UPDATE
    @PutMapping
    <RentalWebModel> ResponseEntity<RentalWebModel> updateRental(@RequestBody RentalWebModel rentalWebModel) {
        return ResponseEntity.ok(rentalService.updateRental(rentalWebModel));
    }

    //DELETE
    @DeleteMapping
    <RentalWebModel> ResponseEntity<RentalWebModel> deleteRental(@PathVariable Long id) {
        return ResponseEntity.ok(rentalService.deleteRental(id));
    }
}
