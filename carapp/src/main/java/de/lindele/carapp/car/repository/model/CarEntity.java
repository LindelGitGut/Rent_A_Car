package de.lindele.carapp.car.repository.model;

import de.lindele.carapp.rental.repository.model.RentalEntity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import lombok.*;

/** Entity class for the car table. */
@Entity
@Data
@Table(name = "car")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class CarEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String brand;
  private String model;
  private String color;
  private String registrationNumber;
  private int kilometer; // Kilometerstand
  private BigDecimal pricePerKilometer;

  @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<RentalEntity> rentals;
}
