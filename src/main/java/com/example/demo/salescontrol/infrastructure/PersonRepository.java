package com.example.demo.salescontrol.infrastructure;

import com.example.demo.salescontrol.model.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {

    Person findOneByIdAndDeletedIsFalse(Integer personId);

    Iterable<Person> findAllByDeletedIsFalse();
}