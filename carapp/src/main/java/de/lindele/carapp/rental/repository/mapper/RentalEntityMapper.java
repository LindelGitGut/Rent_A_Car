package de.lindele.carapp.rental.repository.mapper;

import de.lindele.carapp.car.repository.model.CarEntity;
import de.lindele.carapp.customer.repository.model.CustomerEntity;
import de.lindele.carapp.rental.repository.model.RentalEntity;
import de.lindele.carapp.rental.service.model.Rental;

public class RentalEntityMapper {

    public static Rental entityToModel(RentalEntity entity) {
        Rental model = new Rental();
        model.setId(entity.getId());
        model.setCustomerId(entity.getCustomer().getId());
        model.setCarId(entity.getCar().getId());
        model.setRentalDate(entity.getRentalDate());
        model.setReturnDate(entity.getReturnDate());
        model.setKilometers(entity.getKilometers());
        return model;
    }

    public static RentalEntity modelToEntity(Rental model, CustomerEntity customer, CarEntity car) {
        RentalEntity entity = new RentalEntity();
        entity.setId(model.getId());
        entity.setCustomer(customer);
        entity.setCar(car);
        entity.setRentalDate(model.getRentalDate());
        entity.setReturnDate(model.getReturnDate());
        entity.setKilometersDriven(model.getKilometersDriven());
        return entity;
    }
}