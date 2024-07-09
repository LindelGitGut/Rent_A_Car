package de.lindele.carapp.car.service.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Car {

    private String make;
    private String model;
    private String color;
    private String registrationNumber;
    private Integer drivenkilometers;
    private double pricePerKilometer;

}
