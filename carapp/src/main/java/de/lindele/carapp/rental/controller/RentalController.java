package de.lindele.carapp.rental.controller;

import de.lindele.carapp.rental.controller.mapper.RentalWebModelMapper;
import de.lindele.carapp.rental.controller.model.RentalWebModel;
import de.lindele.carapp.rental.controller.model.request.CreateRentalRequest;
import de.lindele.carapp.rental.controller.model.request.UpdateRentalRequest;
import de.lindele.carapp.rental.service.RentalService;
// import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rental")
@Tag(name = "Rental Management", description = "APIs for managing Rentals")
@RequiredArgsConstructor
public class RentalController {

  private final RentalService rentalService;

  private final RentalWebModelMapper rentalWebModelMapper;

  // TODO Implement CRUD-Endpoints
  // CREATE

  @PostMapping
  ResponseEntity<RentalWebModel> createRental(
      @RequestBody @Validated CreateRentalRequest createRentalRequest) {

    return ResponseEntity.ok(
        rentalWebModelMapper.map(
            rentalService.createRental(
                createRentalRequest.getStartDate(),
                createRentalRequest.getEndDate(),
                createRentalRequest.getCarId(),
                createRentalRequest.getUserId())));
  }

  // READ
  @GetMapping("/{id}")
  ResponseEntity<RentalWebModel> getRental(@PathVariable Long id) {
    return ResponseEntity.ok(rentalWebModelMapper.map(rentalService.getRental(id)));
  }

  // UPDATE
  @PutMapping
  ResponseEntity<RentalWebModel> updateRental(
      @RequestBody UpdateRentalRequest updateRentalRequest) {
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
