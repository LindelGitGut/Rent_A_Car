package de.lindele.carapp.car.controller.mapper;


import de.lindele.carapp.car.controller.model.CarWebModel;
import de.lindele.carapp.car.service.model.Car;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


//TODO Implement Mapping
@Component
public class CarWebModelMapper {


    public Car map(CarWebModel carWebModel) {

        //TODO Test is properties are copied correctly, testing

        Car car = new Car();
        car.setModel(car.getModel());
        car.setMake(carWebModel.getMake());
        car.setDrivenkilometers(carWebModel.getDrivenkilometers());
        car.setRegistrationNumber(car.getRegistrationNumber());
        car.setPricePerKilometer(car.getPricePerKilometer());
        car.setColor(carWebModel.getColor());
        return car;
    }

    public CarWebModel map(Car car) {
        CarWebModel carWebModel= new CarWebModel();
        carWebModel.setModel(car.getModel());
        carWebModel.setMake(car.getMake());
        carWebModel.setDrivenkilometers(car.getDrivenkilometers());
        carWebModel.setRegistrationNumber(car.getRegistrationNumber());
        carWebModel.setPricePerKilometer(car.getPricePerKilometer());
        carWebModel.setColor(car.getColor());
        return carWebModel;
    }


}
