package com.example.demo.salescontrol.model.service;

import com.example.demo.salescontrol.model.entities.Person;
import org.springframework.stereotype.Service;

@Service
public interface PersonService {

    Iterable<Person> getAllUsers();

    Person insertPerson(Person person);

    Person updatePerson(Person person, Integer id);

    Person deletePerson(Integer id);

}
