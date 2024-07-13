package de.lindele.carapp.customer.repository.adapter;

import static org.junit.jupiter.api.Assertions.*;

import de.lindele.carapp.customer.repository.mapper.CustomerEntityMapper;
import de.lindele.carapp.customer.repository.model.CustomerEntity;
import de.lindele.carapp.customer.service.model.Customer;
import de.lindele.carapp.rental.repository.model.RentalEntity;
import java.sql.Date;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CustomerRepositoryAdapterTest {

  @Spy private CustomerEntityMapper customerEntityMapper;
  @Mock private CustomerRepository customerRepository;
  @InjectMocks private CustomerRepositoryAdapter customerRepositoryAdapter;

  @Test
  void findCustomerById() {

    CustomerEntity customerEntity =
        CustomerEntity.builder()
            .id(1L)
            .firstname("firstname")
            .lastname("lastname")
            .address("address")
            .birthdate(new Date(2021, 1, 1))
            .city("city")
            .postalCode("postalCode")
            .phoneNumber("phoneNumber")
            .email("email")
            .rentals(new ArrayList<RentalEntity>())
            .build();

    Mockito.when(customerRepository.findById(1L)).thenReturn(java.util.Optional.of(customerEntity));

    Customer customer = customerRepositoryAdapter.findCustomerById(1L);

    Mockito.verify(customerRepository, Mockito.times(1)).findById(1L);
    Mockito.verify(customerEntityMapper, Mockito.times(1)).map(customerEntity);
    assertNotNull(customer);

    Customer expectedCustomer =
        Customer.builder()
            .id(1L)
            .firstname("firstname")
            .lastname("lastname")
            .address("address")
            .birthdate(new Date(2021, 1, 1))
            .city("city")
            .postalCode("postalCode")
            .phoneNumber("phoneNumber")
            .email("email")
            .build();

    assertEquals(expectedCustomer, customer);
  }

  @Test
  void saveCustomer() {

    var customer =
        Customer.builder()
            .id(1L)
            .firstname("firstname")
            .lastname("lastname")
            .address("address")
            .birthdate(new Date(2021, 1, 1))
            .city("city")
            .postalCode("postalCode")
            .phoneNumber("phoneNumber")
            .email("email")
            .build();

    var customerEntity =
        CustomerEntity.builder()
            .id(1L)
            .firstname("firstname")
            .lastname("lastname")
            .address("address")
            .birthdate(new Date(2021, 1, 1))
            .city("city")
            .postalCode("postalCode")
            .phoneNumber("phoneNumber")
            .email("email")
            .rentals(new ArrayList<RentalEntity>())
            .build();

    // Speichern des Repos simulieren
    Mockito.when(customerRepository.save(customerEntity))
        .thenAnswer(
            invocation -> {
              CustomerEntity entity = invocation.getArgument(0);
              entity.setId(1L);
              return entity;
            });

    var savedCustomer = customerEntity.toBuilder().id(1L).build();

    customerRepositoryAdapter.saveCustomer(customer);

    Mockito.verify(customerRepository, Mockito.times(1)).save(savedCustomer);
    Mockito.verify(customerEntityMapper, Mockito.times(1)).map(customer);
  }

  @Test
  void updateCustomer() {

    Customer customer =
        Customer.builder()
            .id(1L)
            .firstname("firstname")
            .lastname("lastname")
            .address("address")
            .birthdate(new Date(2021, 1, 1))
            .city("city")
            .postalCode("postalCode")
            .phoneNumber("phoneNumber")
            .email("email")
            .build();

    CustomerEntity customerEntity =
        CustomerEntity.builder()
            .id(1L)
            .firstname("firstname")
            .lastname("lastname")
            .address("address")
            .birthdate(new Date(2021, 1, 1))
            .city("city")
            .postalCode("postalCode")
            .phoneNumber("phoneNumber")
            .email("email")
            .rentals(new ArrayList<RentalEntity>())
            .build();

    Mockito.when(customerRepository.save(customerEntity)).thenReturn(customerEntity);

    customerRepositoryAdapter.updateCustomer(customer);

    Mockito.verify(customerRepository, Mockito.times(1)).findById(1L);
  }

  @Test
  void deleteCustomer() {

    CustomerEntity customerEntity =
        CustomerEntity.builder()
            .id(1L)
            .firstname("firstname")
            .lastname("lastname")
            .address("address")
            .birthdate(new Date(2021, 1, 1))
            .city("city")
            .postalCode("postalCode")
            .phoneNumber("phoneNumber")
            .email("email")
            .rentals(new ArrayList<RentalEntity>())
            .build();

    Mockito.when(customerRepository.findById(1L)).thenReturn(java.util.Optional.of(customerEntity));

    customerRepositoryAdapter.deleteCustomer(1L);

    Mockito.verify(customerRepository, Mockito.times(1)).delete(customerEntity);
  }

  @Test
  void findAllCustomer() {

    CustomerEntity customerEntity1 =
        CustomerEntity.builder()
            .id(1L)
            .firstname("firstname")
            .lastname("lastname")
            .address("address")
            .birthdate(new Date(2021, 1, 1))
            .city("city")
            .postalCode("postalCode")
            .phoneNumber("phoneNumber")
            .email("email")
            .rentals(new ArrayList<RentalEntity>())
            .build();

    CustomerEntity customerEntity2 =
        CustomerEntity.builder()
            .id(2L)
            .firstname("firstname")
            .lastname("lastname")
            .address("address")
            .birthdate(new Date(2021, 1, 1))
            .city("city")
            .postalCode("postalCode")
            .phoneNumber("phoneNumber")
            .email("email")
            .rentals(new ArrayList<RentalEntity>())
            .build();

    //    Mockito.when(customerRepository.findAll()).thenReturn(List.of(customerEntity1,
    // customerEntity2));
    //
    //    Page<Customer> customers = customerRepositoryAdapter.findAllCustomer(Pageable.unpaged());
    //
    //    Mockito.verify(customerRepository, Mockito.times(1)).findAll();
    //    Mockito.verify(customerEntityMapper,
    // Mockito.times(2)).map(Mockito.any(CustomerEntity.class));
    //    assertNotNull(customers);

    Customer expectedCustomer1 =
        Customer.builder()
            .id(1L)
            .firstname("firstname")
            .lastname("lastname")
            .address("address")
            .birthdate(new Date(2021, 1, 1))
            .city("city")
            .postalCode("postalCode")
            .phoneNumber("phoneNumber")
            .email("email")
            .build();

    Customer expectedCustomer2 =
        Customer.builder()
            .id(2L)
            .firstname("firstname")
            .lastname("lastname")
            .address("address")
            .birthdate(new Date(2021, 1, 1))
            .city("city")
            .postalCode("postalCode")
            .phoneNumber("phoneNumber")
            .email("email")
            .build();
  }

  @Test
  void findAllCustomerByFirstName() {}

  @Test
  void findAllCustomerByLastName() {}

  @Test
  void findAllCustomerByFirstNameAndLastName() {}
}
