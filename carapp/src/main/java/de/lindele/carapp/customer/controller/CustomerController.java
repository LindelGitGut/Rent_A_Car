package de.lindele.carapp.customer.controller;

import de.lindele.carapp.customer.controller.mapper.CreateCustomerRequestMapper;
import de.lindele.carapp.customer.controller.mapper.CustomerWebModelMapper;
import de.lindele.carapp.customer.controller.mapper.UpdateCustomerRequestMapper;
import de.lindele.carapp.customer.controller.model.CustomerWebModel;
import de.lindele.carapp.customer.controller.model.request.CreateCustomerRequest;
import de.lindele.carapp.customer.controller.model.request.UpdateCustomerRequest;
import de.lindele.carapp.customer.service.CustomerService;
// import io.swagger.annotations.Api;
import de.lindele.carapp.customer.service.model.Customer;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/** Controller for managing customers. */
@RestController
@RequestMapping("/customer")
@Tag(name = "Customer Management", description = "APIs for managing Customers")
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerService customerService;

  private final CustomerWebModelMapper customerWebModelMapper;

  private final CreateCustomerRequestMapper createCustomerRequestMapper;

  private final UpdateCustomerRequestMapper updateCustomerRequestMapper;

  // CREATE
  /**
   * Creates a customer.
   *
   * @param createCustomerRequest The request to create a customer.
   * @return The created customer.
   */
  @PostMapping
  ResponseEntity<CustomerWebModel> createCustomer(
      @RequestBody @Validated CreateCustomerRequest createCustomerRequest) {
    Customer customer = createCustomerRequestMapper.map(createCustomerRequest);
    Customer savedCustomer = customerService.createCustomer(customer);
    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedCustomer.getId())
            .toUri();
    return ResponseEntity.created(location).body(customerWebModelMapper.map(savedCustomer));
  }

  // READ

  /**
   * Gets a customer by id.
   *
   * @param id The id of the customer.
   * @return The customer.
   */
  @GetMapping("/{id}")
  ResponseEntity<CustomerWebModel> getCustomer(@PathVariable Long id) {
    Customer customer = customerService.getCustomerById(id);
    return ResponseEntity.ok(customerWebModelMapper.map(customer));
  }

  /**
   * Gets all customers.
   *
   * @param pageable The pageable object.
   * @param firstName The first name of the customer.
   * @param lastName The last name of the customer.
   * @return The customers.
   */
  @GetMapping
  ResponseEntity<Page<CustomerWebModel>> getAllCustomers(
      @PageableDefault(size = 10) Pageable pageable,
      @RequestParam(required = false) String firstName,
      @RequestParam(required = false) String lastName) {
    Page<Customer> customers;

    if (firstName != null && lastName != null) {
      customers =
          customerService.getAllCustomersByFirstNameAndLastName(firstName, lastName, pageable);
      return ResponseEntity.ok(customers.map(customerWebModelMapper::map));
    } else if (firstName != null) {
      customers = customerService.getAllCustomersByFirstName(firstName, pageable);
      return ResponseEntity.ok(customers.map(customerWebModelMapper::map));
    } else if (lastName != null) {
      customers = customerService.getAllCustomersByLastName(lastName, pageable);
      return ResponseEntity.ok(customers.map(customerWebModelMapper::map));
    } else {
      customers = customerService.getAllCustomers(pageable);
      return ResponseEntity.ok(customers.map(customerWebModelMapper::map));
    }
  }

  // UPDATE
  /**
   * Updates a customer.
   *
   * @param updateCustomerRequest The request to update a customer.
   * @param id The id of the customer.
   * @return The updated customer.
   */
  @PutMapping
  ResponseEntity<CustomerWebModel> updateCustomer(
      @RequestBody @Validated UpdateCustomerRequest updateCustomerRequest, @RequestParam Long id) {
    Customer customer = updateCustomerRequestMapper.map(updateCustomerRequest);
    return ResponseEntity.ok(
        customerWebModelMapper.map(customerService.updateCustomer(customer, id)));
  }

  // DELETE
  /**
   * Deletes a customer.
   *
   * @param id The id of the customer.
   * @return The response entity.
   */
  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
    customerService.deleteCustomer(id);
    return ResponseEntity.noContent().build();
  }
}
