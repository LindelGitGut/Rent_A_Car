package de.lindele.carapp.car.controller.model.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
public class CreateCarRequest {

    @NotNull
    @NotBlank
    private Long id;

    @NotNull
    @NotBlank
    private String brand;

    @NotNull
    @NotBlank
    private String model;

    @NotNull
    @NotBlank
    private String color;

    @NotNull
    @NotBlank
    private String registrationNumber;

    @NotNull
    @NotBlank
    private int kilometer;

    @NotNull
    @NotBlank
    private double pricePerKilometer;


}
