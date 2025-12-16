package com.example.person_api.controller;

import com.example.person_api.model.Person;
import com.example.person_api.model.Student;
import com.example.person_api.model.Teacher;
import com.example.person_api.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public void addPerson(@RequestBody Map<String, Object> personData) {
    Person person;

    if (personData.containsKey("group")) {

        person = new Student(
            ((Number) personData.get("id")).longValue(),
            (String) personData.get("name"),
            (Integer) personData.get("age"),
            (String) personData.get("group")
        );
    } else if (personData.containsKey("subject")) {
        person = new Teacher(
            ((Number) personData.get("id")).longValue(),
            (String) personData.get("name"),
            (Integer) personData.get("age"),
            (String) personData.get("subject")
        );
    } else {
        person = new Person(
            ((Number) personData.get("id")).longValue(),
            (String) personData.get("name"),
            (Integer) personData.get("age")
        );
    }

    service.add(person);
}


    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        service.remove(id);
    }
}
