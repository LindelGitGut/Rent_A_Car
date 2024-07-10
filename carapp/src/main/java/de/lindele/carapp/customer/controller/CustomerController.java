package de.lindele.carapp.customer.controller;


import de.lindele.carapp.customer.controller.mapper.CustomerWebModelMapper;
import de.lindele.carapp.customer.controller.model.CustomerWebModel;
import de.lindele.carapp.customer.service.CustomerService;
//import io.swagger.annotations.Api;
import de.lindele.carapp.customer.service.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/customer")
//@Api(value = "Customer Management System")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    CustomerWebModelMapper customerWebModelMapper;



    //TODO test CRUD-Endpoints
    //CREATE
    @PostMapping
   ResponseEntity<CustomerWebModel> createCustomer(@RequestBody CustomerWebModel customerWebModel) {
        Customer customer = customerWebModelMapper.map(customerWebModel);
            Customer savedCustomer = customerService.createCustomer(customer);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(savedCustomer.getId()).toUri();
            return ResponseEntity.created(location).body(customerWebModelMapper.map(savedCustomer));
        }



    //READ
    @GetMapping
  ResponseEntity<CustomerWebModel> getCustomer(@PathVariable Long id) {
        Customer customer = customerService.getCustomer(id);
        return ResponseEntity.ok(customerWebModelMapper.map(customer));
    }

    @GetMapping
    ResponseEntity<Page<CustomerWebModel>> getAllCustomers(
            @PageableDefault(size = 10) Pageable pageable,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName
    ){
        Page<Customer> customers;

        if (firstName != null && lastName != null) {
            customers = customerService.getAllCustomersByFirstNameAndLastName(firstName, lastName, pageable);
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

    //UPDATE
    @PutMapping
    ResponseEntity<CustomerWebModel> updateCustomer(
            @RequestBody CustomerWebModel customerWebModel,
            @RequestParam Long id) {
       Customer customer = customerWebModelMapper.map(customerWebModel);
        return ResponseEntity.ok(customerWebModelMapper.map(customerService.updateCustomer(customer, id)));
    }

    //DELETE
    @DeleteMapping
     ResponseEntity<CustomerWebModel> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

}
