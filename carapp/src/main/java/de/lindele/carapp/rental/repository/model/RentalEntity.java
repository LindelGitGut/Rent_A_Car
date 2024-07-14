package de.lindele.carapp.rental.repository.model;

import de.lindele.carapp.car.repository.model.CarEntity;
import de.lindele.carapp.customer.repository.model.CustomerEntity;
import jakarta.persistence.*;
import java.util.Date;
import lombok.*;

/** Entity for a rental. */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = "Rental")
public class RentalEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "customer_id", nullable = false)
  private CustomerEntity customer;

  @ManyToOne
  @JoinColumn(name = "car_id", nullable = false)
  private CarEntity car;

  @Temporal(TemporalType.DATE)
  private Date rentalStart;

  @Temporal(TemporalType.DATE)
  private Date rentalEnd;

  private Integer kilometersDriven;
}
