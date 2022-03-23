package com.tuyo.associations.manytomany.repos;

import com.bharath.springdata.associations.manytomany.entities.Programmer;
import org.springframework.data.repository.CrudRepository;

public interface ProgramadorRepository extends CrudRepository<Programmer, Integer> {

}
