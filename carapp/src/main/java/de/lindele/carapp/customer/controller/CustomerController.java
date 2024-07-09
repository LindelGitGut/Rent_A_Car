package de.lindele.carapp.customer.controller;


import de.lindele.carapp.customer.controller.model.CustomerWebModel;
import de.lindele.carapp.customer.service.CustomerService;
//import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
//@Api(value = "Customer Management System")
public class CustomerController {

    @Autowired
    CustomerService customerService;



    //TODO Implement CRUD-Endpoints
    //CREATE

    @PostMapping
   ResponseEntity<CustomerWebModel> createCustomer(@RequestBody CustomerWebModel customerWebModel) {
        //return ResponseEntity.ok(customerService.createCustomer(customerWebModel));
        return null;
    }


    //READ
    @GetMapping
  ResponseEntity<CustomerWebModel> getCustomer(@PathVariable Long id) {
       // return ResponseEntity.ok(customerService.getCustomer(id));
        return null;
    }
    //UPDATE
    @PutMapping
    ResponseEntity<CustomerWebModel> updateCustomer(@RequestBody CustomerWebModel customerWebModel) {
        //return ResponseEntity.ok(customerService.updateCustomer(customerWebModel));
        return null;
    }

    //DELETE
    @DeleteMapping
     ResponseEntity<CustomerWebModel> deleteCustomer(@PathVariable Long id) {
       // return ResponseEntity.ok(customerService.deleteCustomer(id));
        return null;
    }

}
