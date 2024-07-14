package de.lindele.carapp.customer.repository.model;

import de.lindele.carapp.rental.repository.model.RentalEntity;
import jakarta.persistence.*;
import java.sql.Date;
import java.util.List;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor
@Table(name = "customer")

/** Entity for the customer. */

// TODO Adressdaten müssen eigentlich in eine eigne Tabelle ausgelagert werden um 3NF zu
// gewährleisten
public class CustomerEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String firstname;
  private String lastname;
  private String address;
  private Date birthdate;
  private String city;
  private String postalCode;
  private String phoneNumber;
  private String email;

  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<RentalEntity> rentals;
}
