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
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/customer")
// @Api(value = "Customer Management System")
@RequiredArgsConstructor
public class CustomerController {

  private CustomerService customerService;

  private CustomerWebModelMapper customerWebModelMapper;

  private CreateCustomerRequestMapper createCustomerRequestMapper;

  private UpdateCustomerRequestMapper updateCustomerRequestMapper;

  // TODO test CRUD-Endpoints
  // CREATE

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
  @GetMapping("/{id}")
  ResponseEntity<CustomerWebModel> getCustomer(@PathVariable Long id) {
    Customer customer = customerService.getCustomer(id);
    return ResponseEntity.ok(customerWebModelMapper.map(customer));
  }

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

  // TODO benötigt erstmal rental um ordentlich zu funktionieren
  // UPDATE
  @PutMapping
  ResponseEntity<CustomerWebModel> updateCustomer(
      @RequestBody @Validated UpdateCustomerRequest updateCustomerRequest, @RequestParam Long id) {
    Customer customer = updateCustomerRequestMapper.map(updateCustomerRequest);
    return ResponseEntity.ok(
        customerWebModelMapper.map(customerService.updateCustomer(customer, id)));
  }

  // DELETE
  @DeleteMapping("/{id}")
  ResponseEntity<CustomerWebModel> deleteCustomer(@PathVariable Long id) {
    customerService.deleteCustomer(id);
    return ResponseEntity.noContent().build();
  }
}
