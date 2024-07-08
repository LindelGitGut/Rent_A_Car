package de.lindele.carapp.car.repository.model;

import de.lindele.carapp.rental.repository.model.RentalEntity;
import de.lindele.carapp.rental.service.model.Rental;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class CarEntity {
    public class Car {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String make;
        private String model;
        private String registrationNumber;

        @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<RentalEntity> rentals;
    }
}