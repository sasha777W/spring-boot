package com.example.person_api.service;

import com.example.person_api.model.*;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private final List<Person> persons = new ArrayList<>();

    @PostConstruct
    public void init() {
        persons.add(new Person(1L, "John", 30));
        persons.add(new Student(2L, "Alice", 20, "CS-21"));
        persons.add(new Teacher(3L, "Mr. Smith", 45, "Mathematics"));
    }

    public List<Person> getAll() {
        return persons;
    }

    public void add(Person person) {
        persons.add(person);
    }

    public boolean remove(Long id) {
        return persons.removeIf(p -> p.getId().equals(id));
    }
}
