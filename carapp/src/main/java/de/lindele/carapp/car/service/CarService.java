package de.lindele.carapp.car.service;


import de.lindele.carapp.car.controller.model.CarWebModel;
import de.lindele.carapp.car.repository.CarRepository;
import de.lindele.carapp.car.service.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;



    Car createCar(Car car) {
        carRepository.save(car);
    }


}
