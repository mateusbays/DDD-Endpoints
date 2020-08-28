package com.example.demo.salescontrol.actions.controllers;

import com.example.demo.salescontrol.model.entities.Person;
import com.example.demo.salescontrol.model.service.PersonService;
import com.example.demo.salescontrol.model.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    @Autowired
    private PersonServiceImpl personService;

    @GetMapping("/v1/persons")
    public @ResponseBody Iterable<Person> getAllUsers() {
        return personService.getAllUsers();
    }

    @PostMapping("/v1/persons")
    public Person insertPerson(@RequestBody Person person) {
        return personService.insertPerson(person);
    }

    @PutMapping("/v1/persons/{id}")
    public Person updatePerson(@RequestBody Person person, @PathVariable Integer id) {
        return personService.updatePerson(person, id);
    }

    @DeleteMapping("/v1/persons/{id}")
    public Person deletePerson(@PathVariable("id") Integer id) {
        return personService.deletePerson(id);
    }

}
