package de.lindele.carapp.customer.service.model;

import java.sql.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Customer {
  private Long id;
  private String firstname;
  private String lastname;
  private String address;
  private Date birthdate;
  private String city;
  private String postalCode;
  private String phoneNumber;
  private String email;
}
