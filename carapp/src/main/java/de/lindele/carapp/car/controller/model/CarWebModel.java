package de.lindele.carapp.car.controller.model;


//TODO define model

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarWebModel {

    //TODO check which Properties are needed for Webmodel

    private String make;
    private String model;
    private String registrationNumber;
    private String color;
    private Integer drivenkilometers;
    private double pricePerKilometer;

    @Override
    public String toString() {
        return "CarWebModel{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", color='" + color + '\'' +
                ", drivenkilometers=" + drivenkilometers +
                ", pricePerKilometer=" + pricePerKilometer +
                '}';
    }
}
