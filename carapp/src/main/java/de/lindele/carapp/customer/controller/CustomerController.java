package de.lindele.carapp.customer.controller;


import de.lindele.carapp.customer.service.CustomerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/customer")
@Api(value = "Customer Management System")
public class CustomerController {

    @Autowired
    CustomerService customerService;



    //TODO Implement CRUD-Endpoints
    //CREATE

    @PostMapping
    <CustomerWebModel> ResponseEntity<CustomerWebModel> createCustomer(@RequestBody CustomerWebModel customerWebModel) {
        return ResponseEntity.ok(customerService.createCustomer(customerWebModel));
    }


    //READ
    @GetMapping
    <CustomerWebModel> ResponseEntity<CustomerWebModel> getCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomer(id));
    }
    //UPDATE
    @PutMapping
    <CustomerWebModel> ResponseEntity<CustomerWebModel> updateCustomer(@RequestBody CustomerWebModel customerWebModel) {
        return ResponseEntity.ok(customerService.updateCustomer(customerWebModel));
    }

    //DELETE
    @DeleteMapping
    <CustomerWebModel> ResponseEntity<CustomerWebModel> deleteCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.deleteCustomer(id));
    }

}
