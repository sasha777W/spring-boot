package com.example.person_api.controller;

import com.example.person_api.model.Person;
import com.example.person_api.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return service.getAll();
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        service.add(person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        service.remove(id);
    }
}
