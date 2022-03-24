package com.tuyo.associations.manytomany.repos;

import com.tuyo.associations.manytomany.entities.Programador;
import org.springframework.data.repository.CrudRepository;

public interface ProgramadorRepository extends CrudRepository<Programador, Integer> {

}
