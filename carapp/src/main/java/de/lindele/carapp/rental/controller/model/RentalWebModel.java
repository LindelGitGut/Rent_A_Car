package de.lindele.carapp.rental.controller.model;

import de.lindele.carapp.car.repository.model.CarEntity;
import de.lindele.carapp.car.service.model.Car;
import de.lindele.carapp.customer.repository.model.CustomerEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class RentalWebModel {

    @NotNull
    private Long rentalNumber;

//    @NotNull
//    @NotBlank
//    private String customerName;

    @NotNull
    private Car car;

    @NotNull
    private Date rentalDate;

    @NotNull
    private Date returnDate;

    @NotNull
    private int rentalKilometers;
}
