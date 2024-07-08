package de.lindele.carapp.customer.repository;

import de.lindele.carapp.customer.repository.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{
}
