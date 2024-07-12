package de.lindele.carapp.rental.controller;

import de.lindele.carapp.rental.controller.mapper.CreateRentalRequestMapper;
import de.lindele.carapp.rental.controller.mapper.RentalWebModelMapper;
import de.lindele.carapp.rental.controller.mapper.UpdateRentalRequestMapper;
import de.lindele.carapp.rental.controller.model.RentalWebModel;
import de.lindele.carapp.rental.controller.model.request.CreateRentalRequest;
import de.lindele.carapp.rental.service.RentalService;
// import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rental")
// @Api(value = "Rental Management System")
@RequiredArgsConstructor
public class RentalController {

  private final RentalService rentalService;

  private final RentalWebModelMapper rentalWebModelMapper;

  private final CreateRentalRequestMapper createRentalRequestMapper;

  private final UpdateRentalRequestMapper updateRentalRequestMapper;

  // TODO Implement CRUD-Endpoints
  // CREATE

  @PostMapping
  ResponseEntity<RentalWebModel> createRental(
      @RequestBody CreateRentalRequest createRentalRequest) {

    // Rental rental =

    // return ResponseEntity.ok(rentalService.createRental(createRentalRequest));
    return null;
  }

  // READ
  @GetMapping
  ResponseEntity<RentalWebModel> getRental(@PathVariable Long id) {
    // return ResponseEntity.ok(rentalService.getRental(id));
    return null;
  }

  // UPDATE
  @PutMapping
  ResponseEntity<RentalWebModel> updateRental(@RequestBody RentalWebModel rentalWebModel) {
    // return ResponseEntity.ok(rentalService.updateRental(rentalWebModel));
    return null;
  }

  // DELETE
  @DeleteMapping
  ResponseEntity<RentalWebModel> deleteRental(@PathVariable Long id) {
    // return ResponseEntity.ok(rentalService.deleteRental(id));
    return null;
  }
}
