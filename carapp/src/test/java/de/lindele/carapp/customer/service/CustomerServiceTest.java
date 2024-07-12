package de.lindele.carapp.customer.service;

import static org.junit.jupiter.api.Assertions.*;

import de.lindele.carapp.car.service.model.Car;
import de.lindele.carapp.customer.service.model.Customer;
import de.lindele.carapp.customer.service.port.CustomerPersistencePort;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

  @Mock private CustomerPersistencePort customerPersistencePort;

  @InjectMocks private CustomerService customerService;

  @Test
  void createCustomer() {
    var customer = Customer.builder().build();

    Mockito.when(customerPersistencePort.saveCustomer(customer)).thenReturn(customer);

    customerService.createCustomer(customer);

    Mockito.verify(customerPersistencePort, Mockito.times(1)).saveCustomer(customer);
  }

  @Test
  void updateCustomer() {

    var customer = Customer.builder().build();

    Mockito.when(customerPersistencePort.updateCustomer(customer)).thenReturn(customer);

    customerService.updateCustomer(customer, 1L);

    Mockito.verify(customerPersistencePort, Mockito.times(1)).updateCustomer(customer);
  }

  @Test
  void deleteCustomer() {

    Car car = Car.builder().id(1L).build();

    Mockito.doNothing().when(customerPersistencePort).deleteCustomer(car.getId());

    customerService.deleteCustomer(1L);

    Mockito.verify(customerPersistencePort, Mockito.times(1)).deleteCustomer(car.getId());
  }

  @Test
  void getCustomerById() {

    Customer customer = Customer.builder().id(1L).build();

    Mockito.when(customerPersistencePort.findCustomerById(customer.getId())).thenReturn(customer);

    customerService.getCustomerById(1L);

    Mockito.verify(customerPersistencePort, Mockito.times(1)).findCustomerById(customer.getId());
  }

  @Test
  void getAllCustomers() {

    Customer customer1 = Customer.builder().build();
    Customer customer2 = Customer.builder().build();

    List<Customer> customerList = Arrays.asList(customer1, customer2);

    Pageable pageable = PageRequest.of(0, 10);

    Page<Customer> customerPage = new PageImpl<>(customerList);

    Mockito.when(customerPersistencePort.findAllCustomer(pageable)).thenReturn(customerPage);

    customerService.getAllCustomers(pageable);

    Mockito.verify(customerPersistencePort, Mockito.times(1)).findAllCustomer(pageable);
  }

  @Test
  void getAllCustomersByFirstName() {

    Customer customer1 = Customer.builder().firstname("firstname").build();
    Customer customer2 = Customer.builder().firstname("firstname").build();

    List<Customer> customerList = Arrays.asList(customer1, customer2);

    Pageable pageable = PageRequest.of(0, 10);

    Page<Customer> customerPage = new PageImpl<>(customerList);

    Mockito.when(customerPersistencePort.findAllCustomerByFirstName("Max", pageable))
        .thenReturn(customerPage);

    customerService.getAllCustomersByFirstName("Max", pageable);

    Mockito.verify(customerPersistencePort, Mockito.times(1))
        .findAllCustomerByFirstName("Max", pageable);
  }

  @Test
  void getAllCustomersByLastName() {

    Customer customer1 = Customer.builder().lastname("lastname").build();
    Customer customer2 = Customer.builder().lastname("lastname").build();

    List<Customer> customerList = Arrays.asList(customer1, customer2);

    Pageable pageable = PageRequest.of(0, 10);

    Page<Customer> customerPage = new PageImpl<>(customerList);

    Mockito.when(customerPersistencePort.findAllCustomerByLastName("lastname", pageable))
        .thenReturn(customerPage);

    customerService.getAllCustomersByLastName("lastname", pageable);

    Mockito.verify(customerPersistencePort, Mockito.times(1))
        .findAllCustomerByLastName("lastname", pageable);
  }

  @Test
  void getAllCustomersByFirstNameAndLastName() {

    Customer customer1 = Customer.builder().firstname("firstname").lastname("lastname").build();
    Customer customer2 = Customer.builder().firstname("firstname").lastname("lastname").build();

    List<Customer> customerList = Arrays.asList(customer1, customer2);

    Pageable pageable = PageRequest.of(0, 10);

    Page<Customer> customerPage = new PageImpl<>(customerList);

    Mockito.when(
            customerPersistencePort.findAllCustomerByFirstNameAndLastName(
                "firstname", "lastname", pageable))
        .thenReturn(customerPage);

    customerService.getAllCustomersByFirstNameAndLastName("firstname", "lastname", pageable);

    Mockito.verify(customerPersistencePort, Mockito.times(1))
        .findAllCustomerByFirstNameAndLastName("firstname", "lastname", pageable);
  }
}
