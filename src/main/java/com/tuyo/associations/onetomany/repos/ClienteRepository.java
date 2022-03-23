package com.tuyo.associations.onetomany.repos;

import com.bharath.springdata.associations.onetomany.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Customer, Long> {

}
