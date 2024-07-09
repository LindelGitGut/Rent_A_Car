package de.lindele.carapp.car.repository.model;

import de.lindele.carapp.rental.repository.model.RentalEntity;
import jakarta.persistence.*;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "car")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private String color;
    private String registrationNumber;
    private int kilometer; // Kilometerstand
    private double pricePerKilometer;
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RentalEntity> rentals;
}
