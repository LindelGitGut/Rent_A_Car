package de.lindele.carapp.customer.controller.model;

import java.sql.Date;
import lombok.Data;

/** Web model for customer data. */
@Data
public class CustomerWebModel {

  private String firstname;
  private String lastname;
  private String address;
  private Date birthdate;
  private String city;
  private String postalCode;
  private String phoneNumber;
  private String email;
}
