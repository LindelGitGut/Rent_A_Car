package de.lindele.carapp.car.controller.mapper;


import de.lindele.carapp.car.controller.model.request.CreateCarRequest;
import de.lindele.carapp.car.service.model.Car;
import org.springframework.stereotype.Component;

@Component
public class CreateCarRequestMapper {

//
//    private String brand;
//    private String model;
//    private String color;
//    private String registrationNumber;
//    private Integer drivenkilometers;
//    private double pricePerKilometer

    public Car map (CreateCarRequest createCarRequest){
        Car car = new Car();
        car.setBrand(createCarRequest.getBrand());
        car.setModel(createCarRequest.getModel());
        car.setColor(createCarRequest.getColor());
        car.setRegistrationNumber(createCarRequest.getRegistrationNumber());
        car.setDrivenkilometers(createCarRequest.getKilometer());
        car.setPricePerKilometer(createCarRequest.getPricePerKilometer());

        return car;
    }


    public CreateCarRequest map (Car car) {
        CreateCarRequest createCarRequest = new CreateCarRequest();
        createCarRequest.setBrand(car.getBrand());
        createCarRequest.setModel(car.getModel());
        createCarRequest.setColor(car.getColor());
        createCarRequest.setRegistrationNumber(car.getRegistrationNumber());
        createCarRequest.setKilometer(car.getDrivenkilometers());
        createCarRequest.setPricePerKilometer(car.getPricePerKilometer());

        return createCarRequest;
    }

}
