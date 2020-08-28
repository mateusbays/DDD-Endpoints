package com.example.demo.salescontrol.model.service;

import com.example.demo.salescontrol.infrastructure.PersonRepository;
import com.example.demo.salescontrol.model.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Iterable<Person> getAllUsers() {
        return personRepository.findAllByDeletedIsFalse();
    }

    @Override
    public Person insertPerson(Person person) {
        Person personSave = new Person();
        personSave.setName(person.getName());
        return personRepository.save(personSave);
    }

    @Override
    public Person updatePerson(Person person, Integer id) {
        Person personSave = personRepository.findOneByIdAndDeletedIsFalse(id);
        personSave.setName(person.getName());
        return personRepository.save(personSave);
    }

    @Override
    public Person deletePerson(Integer id) {
        Person personDelete = personRepository.findOneByIdAndDeletedIsFalse(id);
        System.out.println("Pessoa encontrado.");
        personDelete.setDeleted(true);
        return personRepository.save(personDelete);
    }



}
